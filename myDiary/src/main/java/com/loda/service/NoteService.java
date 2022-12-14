package com.loda.service;

import cn.hutool.core.util.StrUtil;
import com.loda.dao.NoteDao;
import com.loda.entity.po.Note;
import com.loda.entity.po.NoteType;
import com.loda.entity.vo.NoteInfo;
import com.loda.entity.vo.ResultInfo;
import com.loda.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/11/8 20:42
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */

/**
 *              1. 设置回显对象 Note对象
 *             2. 参数的非空判断
 *                 如果为空，code=0，msg=xxx，result=note对象，返回resultInfo对象
 *             2. 调用Dao层，添加云记记录，返回受影响的行数
 *             3. 判断受影响的行数
 *                 如果大于0，code=1
 *                 如果不大于0，code=0，msg=xxx，result=note对象
 *             4. 返回resultInfo对象
 */
public class NoteService {
    private NoteDao noteDao = new NoteDao();

    public ResultInfo<Note> addOrUpdateNote( String typeId,  String title,  String content, String noteId) {
        ResultInfo<Note> resultInfo = new ResultInfo<>();

        if (StrUtil.isBlank(typeId)) {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("typeId is null");
            return resultInfo;
        }
        if (StrUtil.isBlank(title)) {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("title is null");
            return resultInfo;
        }
        if (StrUtil.isBlank(content)) {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("content is null");
            return resultInfo;
        }
        // 设置回显对象 Note对象
        Note note = new Note();
        note.setTypeId(Integer.parseInt(typeId));
        note.setTitle(title);
        note.setContent(content);
        note.setNoteId(Integer.parseInt(noteId));
//        2. 调用Dao层，添加云记记录，返回受影响的行数
        int row = noteDao.addOrUpdateNote(note);
//         *             3. 判断受影响的行数
//                *                 如果大于0，code=1
//                *                 如果不大于0，code=0，msg=xxx，result=note对象
        if (row > 0) {
            resultInfo.setStatusCode(1);
        } else {
            resultInfo.setStatusCode(0);
            //用于前台回显数据
            resultInfo.setRsObj(note);
            resultInfo.setMsg("add note failed!");
        }
        return resultInfo;

    }

    /**
     * 分页查询云记列表
        设置分页参数的默认值
        1. 参数的非空校验
            如果分页参数为空，则设置默认值
        2. 查询当前登录用户的云记数量，返回总记录数 （long类型）
        3. 判断总记录数是否大于0
        4. 如果总记录数大于0，调用Page类的带参构造，得到其他分页参数的值，返回Page对象
        5. 查询当前登录用户下当前页的数据列表，返回note集合
                // 得到数据库中分页查询的开始下标
        6. 将note集合设置到page对象中
        7. 返回Page对象
     * @param pageNumStr
     * @param pageSizeStr
     * @param userId
     * @return
     */
    public Page<Note> findNoteListByPage(String pageNumStr, String pageSizeStr, Integer userId,
                                         String title, String date, String typeId) {
        // 设置分页参数的默认值
        Integer pageNum = 1;
        Integer pageSize = 3;
//        1. 参数的非空校验
//          如果分页参数为空，则设置默认值
        if (!StrUtil.isBlank(pageNumStr)) {
            pageNum = Integer.parseInt(pageNumStr);
        }

        if (!StrUtil.isBlank(pageSizeStr)) {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        // 2. 查询当前登录用户的云记数量，返回总记录数 （long类型）
        long count = noteDao.findNoteCount(userId, title, date, typeId);

        //  3. 判断总记录数是否大于0
        if (count < 1) {
            return null;
        }

        // 4. 如果总记录数大于0，调用Page类的带参构造，得到其他分页参数的值，返回Page对象
        Page<Note> page = new Page<>(pageNum, pageSize, count);

        // 得到数据库中分页查询的开始下标
        Integer startIndex = (pageNum - 1) * pageSize;

        //5. 查询当前登录用户下当前页的数据列表，返回note集合
        List<Note> noteList =  noteDao.findNoteListByPage(userId, startIndex, pageSize, title, date);

        //6. 将note集合设置到page对象中
        page.setDataList(noteList);

        //7. 返回Page对象
        return page;
    }

    public Note findNoteByNoteId(String noteId) {
        //判断参数
        if (StrUtil.isBlank(noteId)) {
            return null;
        }
        //调用Dao层方法，获取数据
        Note note = noteDao.findNoteByNoteId(noteId);
        return note;
    }

    public Integer deleteNoteByNoteId(String noteId) {
        //判断出参数是否为空
        if (StrUtil.isBlank(noteId)) {
            return null;
        }
        Integer row = noteDao.deleteNoteByNoteId(noteId);
        if (row > 0) { //删除成功
            return 1;
        }
        return 0;
    }

    public List<NoteInfo> findNoteCountByDate(Integer userId) {
        return noteDao.findNoteCountByDate(userId);
    }

    public List<NoteInfo> findNoteCountByType(Integer userId) {
        return noteDao.findNoteCountByType(userId);
    }

    public ResultInfo<Map<String, Object>> queryNoteCountByMonth(Integer userId) {
        ResultInfo<Map<String, Object>> resultInfo = new ResultInfo<>();

        // 通过月份分类查询云记数量
        List<NoteInfo> noteInfos = noteDao.findNoteCountByDate(userId);

        // 判断集合是否存在
        if (noteInfos != null && noteInfos.size() > 0) {
            // 月份集合
            List<String> monthList = new ArrayList<>();
            // 云记集合
            List<Integer> noteCountList = new ArrayList<>();

            // 遍历月份分组集合
            for (NoteInfo noteInfo: noteInfos) {
                monthList.add(noteInfo.getGroupName());
                noteCountList.add((int)noteInfo.getNoteCount());
            }

            // 准备Map对象，封装对应的月份与云记数量
            Map<String, Object> map = new HashMap<>();
            map.put("monthArray", monthList);
            map.put("dataArray", noteCountList);

            // 将map对象设置到ResultInfo对象中
            resultInfo.setStatusCode(1);
            resultInfo.setRsObj(map);
        }
        return resultInfo;
    }

    public ResultInfo<List<Note>> queryNoteLonAndLat(Integer userId) {
        ResultInfo<List<Note>> resultInfo = new ResultInfo<>();

        // 通过用户ID查询云记列表
        List<Note> noteList = noteDao.queryNoteList(userId);

        // 判断是否为空
        if (noteList != null && noteList.size() > 0) {
            resultInfo.setStatusCode(1);
            resultInfo.setRsObj(noteList);
        }

        return resultInfo;
    }
}
