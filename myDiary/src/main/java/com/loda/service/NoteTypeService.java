package com.loda.service;

import cn.hutool.core.util.StrUtil;
import com.loda.dao.NoteTypeDao;
import com.loda.entity.po.NoteType;
import com.loda.entity.vo.ResultInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/7 16:16
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class NoteTypeService {
    private NoteTypeDao noteTypeDao = new NoteTypeDao();
    /**
     * 1. 调用Dao层的查询方法，通过用户ID查询类型集合
     * 2. 返回类型集合
     * @param userId
     * @return
     */
    public List<NoteType> noteTypeList( Integer userId) {
        List<NoteType> list = noteTypeDao.queryNoteTypeListByUserId(userId);
        return list;
    }

    /**
     *             1. 判断参数是否为空
     *             2. 调用Dao层，通过类型ID查询云记记录的数量
     *             3. 如果云记数量大于0，说明存在子记录，不可删除
     *                 code=0，msg="该类型存在子记录，不可删除"，返回resultInfo对象
     *             4. 如果不存在子记录，调用Dao层的更新方法，通过类型ID删除指定的类型记录，返回受影响的行数
     *             5. 判断受影响的行数是否大于0
     *                 大于0，code=1；否则，code=0，msg="删除失败"
     *             6. 返回ResultInfo对象
     * @return
     */
    public ResultInfo<NoteType> delType(String typeId ) {
        ResultInfo<NoteType> resultInfo = new ResultInfo<>();
//        1. 判断参数是否为空
        if (typeId == null) {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("typeId is null");
            return resultInfo;
        }
//        2. 调用Dao层，通过类型ID查询云记记录的数量
        Long noteNum = noteTypeDao.queryNoteByTypeId(typeId);
//        3. 如果云记数量大于0，说明存在子记录，不可删除
//             code=0，msg="该类型存在子记录，不可删除"，返回resultInfo对象
        if (noteNum > 0) {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("note num is "+noteNum+" in this type" );
            return resultInfo;
        }
//         4. 如果不存在子记录，调用Dao层的更新方法，通过类型ID删除指定的类型记录，返回受影响的行数
        int row = noteTypeDao.delTypeByTypeId(typeId);
//        5. 判断受影响的行数是否大于0
//              大于0，code=1；否则，code=0，msg="删除失败"
        if (row > 0) {
            resultInfo.setStatusCode(1);
        } else {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("del type failed");
        }
//        6. 返回ResultInfo对象
        return resultInfo;
    }

    /**
     *        1. 判断参数是否为空 （类型名称）
     *                 如果为空，code=0，msg=xxx，返回ResultInfo对象
     *             2. 调用Dao层，查询当前登录用户下，类型名称是否唯一，返回0或1
     *                 如果不可用，code=0，msg=xxx，返回ResultInfo对象
     *             3. 判断类型ID是否为空
     *                 如果为空，调用Dao层的添加方法，返回主键 （前台页面需要显示添加成功之后的类型ID）
     *                 如果不为空，调用Dao层的修改方法，返回受影响的行数
     *             4. 判断 主键/受影响的行数 是否大于0
     *                 如果大于0，则更新成功
     *                     code=1，result=主键
     *                 如果不大于0，则更新失败
     *                     code=0，msg=xxx
     * @param typeId
     * @param userId
     * @return
     */
    public ResultInfo<Integer> addOrUpdateType( String typeId, String typeName, Integer userId) {
        ResultInfo<Integer> resultInfo = new ResultInfo<>();

        if (StrUtil.isBlank(typeName)) {
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("参数为空?");
            return resultInfo;
        }
        //2. 调用Dao层，查询当前登录用户下，类型名称是否唯一，返回0或1
        //   如果不可用，code=0，msg=xxx，返回ResultInfo对象
        Integer num = noteTypeDao.checkTypeName(typeName, userId, typeId);
        if (num == 0) {
            //不可用
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("类型已存在");
            return resultInfo;
        }
        //如果类型可用
        //3. 判断类型ID是否为空
        Integer key = null;
        if (StrUtil.isBlank(typeId)) {
            //如果为空，调用Dao层的添加方法，返回主键 （前台页面需要显示添加成功之后的类型ID）
            key = noteTypeDao.addType(typeName, userId);
        } else {
            //如果不为空，调用Dao层的修改方法，返回受影响的行数
            key = noteTypeDao.updateType(typeId, typeName);
        }

        //  4. 判断 主键/受影响的行数 是否大于0
        if (key > 0) {
            //  如果大于0，则更新成功
            resultInfo.setStatusCode(1);
            //   code=1，result=主键
            resultInfo.setRsObj(key);
        } else {
            //如果不大于0，则更新失败
            resultInfo.setStatusCode(0);
            resultInfo.setMsg("类型已存在");
            return resultInfo;
        }
        return resultInfo;
    }
}
