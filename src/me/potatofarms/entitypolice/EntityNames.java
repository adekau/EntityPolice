package me.potatofarms.entitypolice;

public enum EntityNames {
	Monster							(1, "monster"),
	Zombie							(2, "zombie"),
	Skeleton						(3, "skeleton"),
	Creeper							(4, "creeper"),
	Spider							(5, "spider"),
	Wolf							(6, "wolf");
	
	
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
