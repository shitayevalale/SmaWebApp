package service;

import model.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    boolean saveGroup(Group group);
    Group getGroupInfoById(Long groupId);

    boolean updateGroup(Group group);

    boolean softDeleteGroupById(Long id);
}
