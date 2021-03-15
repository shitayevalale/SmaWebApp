package service.impl;

import Dao.GroupDao;
import model.Group;
import service.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {
    private GroupDao groupDao;

    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }
    @Override
    public List<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }

    @Override
    public boolean saveGroup(Group group) {
        return groupDao.saveGroup(group);
    }

    @Override
    public Group getGroupInfoById(Long groupId) {
        return groupDao.getGroupInfoById(groupId);
    }

    @Override
    public boolean updateGroup(Group group) {
        return groupDao.updateGroup(group);
    }

    @Override
    public boolean softDeleteGroupById(Long id) {
        return groupDao.softDeleteGroupById(id);
    }
}
