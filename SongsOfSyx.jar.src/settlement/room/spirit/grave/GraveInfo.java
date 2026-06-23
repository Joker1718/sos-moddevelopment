/*    */ package settlement.room.spirit.grave;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.type.CAUSE_LEAVE;
/*    */ import init.type.CAUSE_LEAVES;
/*    */ import init.type.HTYPE;
/*    */ import init.type.HTYPES;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.thing.ThingsCorpses;
/*    */ import snake2d.util.bit.BitsLong;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ 
/*    */ public final class GraveInfo
/*    */ {
/* 16 */   private static final GraveInfo self = new GraveInfo();
/*    */   
/* 18 */   private BitsLong gender = new BitsLong(15L);
/* 19 */   private BitsLong race = new BitsLong(16711680L);
/* 20 */   private BitsLong type = new BitsLong(4278190080L);
/* 21 */   private BitsLong cause = new BitsLong(1095216660480L);
/* 22 */   private BitsLong age = new BitsLong(72056494526300160L);
/* 23 */   private BitsLong has = new BitsLong(Long.MIN_VALUE);
/*    */   
/*    */   private GraveInstance ins;
/*    */   
/*    */   private int id;
/*    */   private long dataD;
/*    */   private int nameD;
/*    */   
/*    */   private GraveInfo() {
/* 32 */     if (this.race.mask < RACES.all().size())
/* 33 */       throw new RuntimeException(); 
/* 34 */     if (this.type.mask < HTYPES.ALL().size())
/* 35 */       throw new RuntimeException(); 
/* 36 */     if (this.cause.mask < CAUSE_LEAVES.ALL().size())
/* 37 */       throw new RuntimeException(); 
/*    */   }
/*    */   
/*    */   static GraveInfo get(GraveInstance instance, int id) {
/* 41 */     self.ins = instance;
/* 42 */     self.id = id;
/* 43 */     self.dataD = instance.datas[id];
/* 44 */     self.nameD = instance.names[id];
/* 45 */     return self;
/*    */   }
/*    */   
/*    */   public CharSequence name() {
/* 49 */     return STATS.APPEARANCE().name(race(), type(), this.gender.get(this.dataD), this.nameD);
/*    */   }
/*    */   
/*    */   boolean hasBody() {
/* 53 */     return (this.has.get(this.dataD) > 0);
/*    */   }
/*    */   
/*    */   public Race race() {
/* 57 */     return (Race)RACES.all().get(this.race.get(this.dataD));
/*    */   }
/*    */   
/*    */   public HTYPE type() {
/* 61 */     return (HTYPE)HTYPES.ALL().get(this.type.get(this.dataD));
/*    */   }
/*    */   
/*    */   public CAUSE_LEAVE cause() {
/* 65 */     return (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(this.cause.get(this.dataD));
/*    */   }
/*    */   
/*    */   void clear() {
/* 69 */     this.dataD = this.has.set(this.dataD, 0L);
/* 70 */     this.ins.datas[this.id] = this.dataD;
/*    */   }
/*    */   
/*    */   public int years() {
/* 74 */     return this.age.get(this.dataD);
/*    */   }
/*    */ 
/*    */   
/*    */   void bury(ThingsCorpses.Corpse c) {
/* 79 */     this.dataD = this.has.set(this.dataD, 1L);
/* 80 */     this.dataD = this.gender.set(this.dataD, (STATS.APPEARANCE()).gender.get(c.indu()));
/* 81 */     this.nameD = (STATS.APPEARANCE()).nameData.get(c.indu());
/* 82 */     this.dataD = this.type.set(this.dataD, c.indu().hType().index());
/* 83 */     this.dataD = this.race.set(this.dataD, (c.indu().race()).index);
/* 84 */     this.dataD = this.cause.set(this.dataD, c.cause().index());
/* 85 */     int a = (int)Math.ceil((STATS.POP()).age.years.getD(c.indu()));
/* 86 */     a = CLAMP.i(a, 0, (int)this.age.mask);
/* 87 */     this.dataD = this.age.set(this.dataD, a);
/* 88 */     this.ins.datas[this.id] = this.dataD;
/* 89 */     this.ins.names[this.id] = this.nameD;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\GraveInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */