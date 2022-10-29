package io.ukoko.bhwms.service.impl;

import io.ukoko.bhwms.entity.Department;
import io.ukoko.bhwms.exceptions.BhWmsException;
import io.ukoko.bhwms.mapper.DepartmentMapper;
import io.ukoko.bhwms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void addDepartment(Department department) {
        departmentMapper.addDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) throws BhWmsException{
        //更新前先判断更新的部门状态,如果状态为无效,那么必须在当前部门的下面没有子部门,否则更新失败
        List<Department> list = departmentMapper.getDepartmentListByDeptId(department.getDeptId());
        if(list!=null && list.size()>0){
            throw new BhWmsException(2,"存在子部门,不能更新");
        }else{
            departmentMapper.updateDepartment(department);
        }
    }

    @Override
    public void deleteDepartment(Integer deptId) throws BhWmsException{
        //判断当前部门ID下是否存在有效的子部门,如果不存在方可删除
        List<Department> list = departmentMapper.getDepartmentListByDeptId(deptId);
        if(list!=null && list.size()>0){
            //不能删除,抛出异常
            throw new BhWmsException(1,"存在子部门,不能删除");
        }else{
            //删除
            departmentMapper.deleteDepartment(deptId);
        }

    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentMapper.getDepartmentList();
    }
}
