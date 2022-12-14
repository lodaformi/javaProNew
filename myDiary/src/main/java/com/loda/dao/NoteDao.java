package com.loda.dao;

import cn.hutool.core.util.StrUtil;
import com.loda.entity.po.Note;
import com.loda.entity.vo.NoteInfo;
import com.loda.entity.vo.ResultInfo;
import com.loda.util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/8 20:42
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class NoteDao {
    /**
     * 添加云记，返回受影响的行数
     * @param note
     * @return
     */
    public int addOrUpdateNote(Note note) {
        //定义sql语句
        String sql="";
        //设置参数
        List<Object> params = new ArrayList<>();
        params.add(note.getTypeId());
        params.add(note.getTitle());
        params.add(note.getContent());

        // 判断noteId是否为空；
        if (note.getNoteId() == null) { //如果为空，则为添加操作；
            sql = "insert into tb_note(title, content, typeId, pubTime) values(?, ?, ?, now())";
        } else  { //如果不为空，则为修改操作
            sql = "update tb_note set typeId = ?, title = ?, content = ? where noteId = ?";
            params.add(note.getNoteId());
        }
        //执行更新操作
        int row = BaseDao.updateOp(sql, params);
        return row;
    }


    public long findNoteCount(Integer userId, String title, String date, String typeId) {
        //定义sql
        String sql = "SELECT count(*) FROM TB_NOTE_TYPE T JOIN TB_NOTE N " +
                " ON (T.TYPEID = N.TYPEID) " +
                " WHERE USERID = ? ";
        //设置参数
        List<Object> params = new ArrayList<>();
        params.add(userId);

        if (!StrUtil.isBlank(title)) {
            sql += "and title like concat('%', ?, '%') ";
            params.add(title);
        }

        if (!StrUtil.isBlank(date)) {
            sql += "and date_format(pubTime, '%Y年%m月') = ? ";
            params.add(date);
        }

        if (!StrUtil.isBlank(typeId)){
            sql += "and n.typeId = ? ";
            params.add(typeId);
        }

        //执行查询
        long count = (long) BaseDao.querySingleValue(sql, params);
        //返回结果
        return count;
    }

    /**
     * 查询当前登录用户下当前页的数据列表，返回note集合
     * @param userId
     * @param index
     * @param pageSize
     * @return
     */
    public List<Note> findNoteListByPage(Integer userId, Integer index, Integer pageSize,
                                         String title, String date) {
        //定义sql
        String sql = "SELECT * " +
                "FROM TB_NOTE_TYPE T JOIN TB_NOTE N " +
                "ON (T.TYPEID = N.TYPEID) " +
                "WHERE USERID = ? ";

        //设置参数
        List<Object> params = new ArrayList<>();
        params.add(userId);

        if (!StrUtil.isBlank(title)) {
            sql += "and title like concat('%', ?, '%') ";
            params.add(title);
        }

        if (!StrUtil.isBlank(date)) {
            sql += "and date_format(pubTime, '%Y年%m月') = ? ";
            params.add(date);
        }

        sql += " order by pubTime desc LIMIT ?, ?";

        params.add(index);
        params.add(pageSize);
        //执行查询
        List<Note> list = BaseDao.queryRows(sql, params, Note.class);
        //返回结果
        return list;
    }

    public Note findNoteByNoteId(String noteId) {
        //定义sql
        String sql = "select * from tb_note n join tb_note_type t on (n.typeId = t.typeId) where noteId = ?";
        //设置参数
        List<Object> params = new ArrayList<>();
        params.add(noteId);
        //执行查询
        Note note = (Note) BaseDao.queryRow(sql, params, Note.class);
        return note;
    }

    public Integer deleteNoteByNoteId(String noteId) {
        //定义sql
        String sql = "delete from tb_note where noteId = ?";
        //设置参数
        List<Object> params = new ArrayList<>();
        params.add(noteId);
        //执行查询
        Integer row = BaseDao.updateOp(sql, params);
        //返回结果
        return row;
    }

    public List<NoteInfo> findNoteCountByDate(Integer userId) {
        //定义sql
        String sql = "SELECT COUNT(*) noteCount, DATE_FORMAT(PUBTIME,'%Y年%m月') groupName " +
                "FROM tb_note N JOIN tb_note_type T ON (N.TYPEID = T.TYPEID) WHERE USERID = ? " +
                "GROUP BY DATE_FORMAT(PUBTIME,'%Y年%m月') " +
                "ORDER BY DATE_FORMAT(PUBTIME,'%Y年%m月') DESC";
        //设置参数
        List<Object> params = new ArrayList<>();
        params.add(userId);

        // 调用BaseDao的查询方法
        List<NoteInfo> list = BaseDao.queryRows(sql, params, NoteInfo.class);

        return list;
    }

    public List<NoteInfo> findNoteCountByType(Integer userId) {
// 定义SQL语句
        String sql = "SELECT count(noteId) noteCount, t.typeId, typeName groupName FROM tb_note n " +
                " RIGHT JOIN tb_note_type t ON n.typeId = t.typeId WHERE userId = ? " +
                " GROUP BY t.typeId ORDER BY COUNT(noteId) DESC ";

        // 设置参数
        List<Object> params = new ArrayList<>();
        params.add(userId);

        // 调用BaseDao的查询方法
        List<NoteInfo> list = BaseDao.queryRows(sql, params, NoteInfo.class);

        return list;
    }

    /**
     * 通过用户ID查询云记列表
     * @param userId
     * @return
     */
    public List<Note> queryNoteList(Integer userId) {
        // 定义SQL语句
        String sql = "select lon, lat from  tb_note n inner join tb_note_type t on n.typeId = t.typeId where userId = ?";

        // 设置参数
        List<Object> params = new ArrayList<>();
        params.add(userId);

        // 调用BaseDao
        List<Note> list = BaseDao.queryRows(sql, params, Note.class);

        return list;
    }
}
