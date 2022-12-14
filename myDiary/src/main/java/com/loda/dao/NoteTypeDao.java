package com.loda.dao;

import com.loda.entity.po.NoteType;
import com.loda.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/7 14:50
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class NoteTypeDao {
    /**
     *  通过用户ID查询类型集合
     *             1. 定义SQL语句
     *                 String sql = "select typeId,typeName,userId from tb_note_type where userId = ? ";
     *             2. 设置参数列表
     *             3. 调用BaseDao的查询方法，返回集合
     *             4. 返回集合
     * @param userId
     * @return
     */
    public List<NoteType> queryNoteTypeListByUserId(Integer userId) {
//        1. 定义SQL语句
        String sql = "select * from tb_note_type where userId = ?";
//        2. 设置参数列表
        List<Object> params = new ArrayList<>();
        params.add(userId);
//        3. 调用BaseDao的查询方法，返回集合
        List<NoteType> list = BaseDao.queryRows(sql, params, NoteType.class);
//        4. 返回集合
        return list;
    }

    public Long queryNoteByTypeId(String typeId) {
        //        1. 定义SQL语句
        String sql = "select count(*) from tb_note where typeId = ?";
        //        2. 设置参数列表
        List<Object> params = new ArrayList<>();
        params.add(typeId);
//        3. 调用BaseDao的查询方法，返回个数
        //这里注意，返回值是long
        Long noteNum = (Long) BaseDao.querySingleValue(sql, params);
        //        4. 返回个数
        return noteNum;
    }

    public int delTypeByTypeId(String typeId) {
        //1. 定义SQL语句
        String sql = "delete from tb_note_type where typeId = ?";
        //2. 设置参数列表
        List<Object> params = new ArrayList<>();
        params.add(typeId);
        //3. 调用BaseDao的查询方法，返回个数
        int row = BaseDao.updateOp(sql, params);
        // 4. 返回个数
        return row;
    }

    //查询当前登录用户下，类型名称是否唯一
    public Integer checkTypeName(String typeName, Integer userId, String typeId) {
        //1. 定义SQL语句
        String sql = "select * from tb_note_type where typeName = ? and userId = ?";
        //2. 设置参数列表
        List<Object> params = new ArrayList<>();
        params.add(typeName);
        params.add(userId);
        //3. 调用BaseDao的查询方法，返回个数
        NoteType noteType = (NoteType) BaseDao.queryRow(sql, params, NoteType.class);
        // 如果对象为空，表示可用
        if (noteType == null) {
            return 1;
        } else {
            // 如果是修改操作，则需要判断是否是当前记录本身
            if (typeId.equals(noteType.getTypeId().toString())){
                return 1;
            }
        }
        return 0;
    }

    //添加方法，返回主键
    public Integer addType(String typeName, Integer userId) {
        Integer key = null;
        Connection connection = null;
        PreparedStatement ps =null;
        ResultSet rs =null;

        try {
            connection = DBUtil.getConnection();
            String sql = "insert into tb_note_type(typeName, userId) values(?, ?)";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, typeName);
            ps.setObject(2,userId);
            int row = ps.executeUpdate();
            if (row > 0) {
                //重点
                rs = ps.getGeneratedKeys();
                if (rs.next()){
                    key = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeRes(connection, rs, ps);
        }
        return key;
    }

    //修改方法，返回受影响的行数
    public Integer updateType(String typeId, String typeName) {
        //1. 定义SQL语句
        String sql = "update tb_note_type set typeName = ? where typeId = ?";
        //2. 设置参数列表
        List<Object> params = new ArrayList<>();
        params.add(typeName);
        params.add(typeId);
        //3. 调用BaseDao的更新方法，返回受影响行数
        Integer i = BaseDao.updateOp(sql, params);
        return i;
    }
}
