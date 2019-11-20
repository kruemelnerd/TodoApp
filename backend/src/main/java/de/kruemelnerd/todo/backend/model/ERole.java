package de.kruemelnerd.todo.backend.model;

public enum ERole {
    ROLE_USER ("user"),
    ROLE_MODERATOR ("mod"),
    ROLE_ADMIN("admin");

    private String name;

    ERole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public static ERole getERole (String name){
        final ERole[] values = ERole.values();
        for (ERole role : values){
            if(role.getName().equals(name)){
                return role;
            }
        }
        return null;
    }


}
