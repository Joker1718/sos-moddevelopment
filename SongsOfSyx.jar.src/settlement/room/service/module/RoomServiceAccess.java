/*     */ package settlement.room.service.module;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpecs;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.NEED;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.service.StatServiceRoom;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ public abstract class RoomServiceAccess extends RoomService implements INDEXED {
/*  28 */   private static final ArrayListGrower<RoomServiceAccess> all = new ArrayListGrower();
/*     */ 
/*     */   
/*     */   public static interface ROOM_SERVICE_ACCESS_HASER
/*     */     extends RoomService.ROOM_SERVICE_HASER
/*     */   {
/*     */     RoomServiceAccess service();
/*     */   }
/*     */ 
/*     */   
/*     */   public final StatStanding.StandingDef standingDef;
/*     */   
/*     */   public final String[] induMore;
/*     */   public final BoostSpecs boosts;
/*     */   private final int index;
/*     */   
/*     */   public RoomServiceAccess(RoomBlueprintImp b, RoomInitData data, NEED need) {
/*  45 */     super(b, data, need);
/*  46 */     this.index = all.add(this);
/*  47 */     this.induMore = data.text().json("SERVICE").texts("MORE");
/*  48 */     Json json = data.data().json("SERVICE");
/*  49 */     this.standingDef = new StatStanding.StandingDef(json.json("STANDING"));
/*  50 */     this.boosts = new BoostSpecs(b.info.name, (SPRITE)b.icon, false);
/*  51 */     this.boosts.read(json, BValue.VALUE1);
/*  52 */     this.usage = json.dTry("USAGE", 0.0D, 1.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public final void reportAccess(Humanoid a, COORDINATE c) {
/*  56 */     reportAccess(a, c.x(), c.y());
/*     */   }
/*     */   
/*     */   public final void reportContent(Humanoid a, ROOM_SERVICER service) {
/*  60 */     RoomInstance ins = (RoomInstance)service;
/*  61 */     stats().setAccess(a, true, service.quality(), 1.0D, ins.upgrade());
/*     */   }
/*     */   
/*     */   public final void reportAccess(Humanoid a, int tx, int ty) {
/*  65 */     ROOM_SERVICER r = (ROOM_SERVICER)this.room.get(tx, ty);
/*  66 */     if (r == null)
/*     */       return; 
/*  68 */     RoomInstance ins = (RoomInstance)r;
/*  69 */     stats().setAccess(a, true, r.quality(), stats().proximity(a), ins.upgrade());
/*     */   }
/*     */   
/*     */   public final void reportDistance(Humanoid a) {
/*  73 */     double p = 1.0D - (this.finder.getDistance() - (this.radius / 3)) / this.radius;
/*  74 */     p = CLAMP.d(p, 0.0D, 1.0D);
/*  75 */     p = Math.sqrt(p);
/*  76 */     stats().setProximity(a, p);
/*     */   }
/*     */   
/*     */   public final void clearAccess(Humanoid a) {
/*  80 */     stats().setAccess(a, false, 0.0D, 0.0D, 0);
/*     */   }
/*     */   
/*     */   public final StatServiceRoom stats() {
/*  84 */     return (StatServiceRoom)(STATS.SERVICE()).ROOMS.get(this.index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double cityAccess() {
/*  94 */     double d = 0.0D;
/*  95 */     double p = 0.0D;
/*  96 */     for (int ci = 0; ci < HCLASSES.ALLP().size(); ci++) {
/*  97 */       HCLASS c = (HCLASS)HCLASSES.ALLP().get(ci);
/*  98 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  99 */         Race r = (Race)RACES.all().get(ri);
/* 100 */         if (stats().permission().is(HCLASS_RACE.clP(r, c))) {
/* 101 */           double pp = (STATS.POP()).POP.data(c).get(r);
/* 102 */           p += pp;
/* 103 */           d += pp * stats().access().data(c).getD(r);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 109 */     if (p == 0.0D)
/* 110 */       return 0.0D; 
/* 111 */     return d / p;
/*     */   }
/*     */   
/*     */   public boolean accessRequest(Humanoid a) {
/* 115 */     return stats().accessRequest(a);
/*     */   }
/*     */   
/*     */   public boolean isGoodTime() {
/* 119 */     return true;
/*     */   }
/*     */   
/*     */   public static LIST<RoomServiceAccess> ALL() {
/* 123 */     return (LIST<RoomServiceAccess>)all;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 128 */     return this.index;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\module\RoomServiceAccess.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */