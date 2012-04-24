package me.potatofarms.entitypolice;

public enum EntityNames {
	Monster							(1, "monster"),
	Animal							(2, "Animal"),
	Zombie							(3, "zombie"),
	Skeleton						(4, "skeleton"),
	Creeper							(5, "creeper"),
	Spider							(6, "spider"),
	Wolf							(7, "wolf");
	
	
	private final Integer id;
	private final String name;

	EntityNames(Integer eid, String ename) {
		id = eid;
		name = ename;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
