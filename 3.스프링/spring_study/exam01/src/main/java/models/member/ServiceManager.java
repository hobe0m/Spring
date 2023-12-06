package models.member;

public class ServiceManager {

    private static ServiceManager instance = null;

    private ServiceManager() {}

    public static ServiceManager getInstance() {
        if(instance == null) {
            instance = new ServiceManager();
        }
        return instance;
    }

    public MemberDao memberDao() {
        return new CachedMemberDao();
    }

    public JoinValidator joinValidator() {

        return new JoinValidator(memberDao());
    }

    public JoinService joinService() {
        return new JoinService(memberDao(), joinValidator());
    }

    public ListService listService() {
        ListService listService = new ListService();
        listService.setMemberDao(memberDao());

        return listService;
    }
}
