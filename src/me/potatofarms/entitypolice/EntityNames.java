package me.potatofarms.entitypolice;

public enum EntityNames {
	Monster							(1, "monster"),
	Animal							(2, "animal"),
	Squid							(3, "squid"),
	Mob								(4, "mob"),
	Zombie							(5, "zombie"),
	Skeleton						(6, "skeleton"),
	Creeper							(7, "creeper"),
	Spider							(8, "spider"),
	Wolf							(9, "wolf"),
	Pig								(10, "pig"),
	Chicken							(11, "chicken"),
	Cow								(12, "cow"),
	Sheep							(13, "sheep");
	
	
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
