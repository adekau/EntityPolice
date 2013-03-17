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
	Sheep							(13, "sheep"),
	Blaze							(14, "blaze"),
	EnderDragon						(15, "enderdragon"),
	Ghast							(16, "ghast"),
	Giant							(17, "giant"),
	Golem							(18, "golem"),
	IronGolem						(19, "irongolem"),
	MagmaCube						(20, "magmacube"),
	MushroomCow						(21, "mushroomcow"),
	NPC								(22, "npc"),
	Ocelot							(23, "ocelot"),
	PigZombie						(24, "pigzombie"),
	Silverfish						(25, "silverfish"),
	Slime							(26, "slime"),
	Snowman							(27, "snowman"),
	Villager						(28, "villager"),
	Enderman						(29, "Enderman"),
	Bat								(30, "Bat"),
	Witch							(31, "witch"),
	Wither							(32, "wither"),
	WitherSkeleton					(33, "witherskeleton"),
	ZombieVillager					(34, "zombievillager");
	
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
