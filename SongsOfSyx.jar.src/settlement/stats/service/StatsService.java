/*     */ package settlement.stats.service;
/*     */ 
/*     */ import init.type.NEED;
/*     */ import init.type.NEEDS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.room.service.nursery.ROOM_NURSERY;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class StatsService
/*     */   extends StatCollection
/*     */ {
/*     */   public final LIST<StatServiceImp> ALL;
/*     */   public final LIST<StatServiceRoom> ROOMS;
/*  23 */   private final ArrayList<ArrayListGrower<StatService>> needMap = new ArrayList(NEEDS.ALL().size());
/*  24 */   private final ArrayListGrower<StatServiceImp> allNeeds = new ArrayListGrower();
/*  25 */   private double[] needTot = new double[NEEDS.ALL().size()];
/*     */   
/*     */   public final StatServiceSimple skinnyDip;
/*     */   public final StatServiceBench bench;
/*     */   public final StatServiceHospital hospital;
/*     */   public final LIST<StatServiceChild> nurseries;
/*  31 */   private static CharSequence ¤¤name = "Services";
/*  32 */   private static CharSequence ¤¤descc = "Services are provided by building service rooms and allowing access to your subjects."; private LIST<StatService> shrine;
/*     */   
/*     */   static {
/*  35 */     D.ts(StatsService.class);
/*     */   }
/*     */   private LIST<StatService> temple;
/*     */   public StatsService(StatsInit init) {
/*  39 */     super(init, "SERVICE", ¤¤name, ¤¤descc);
/*     */     
/*  41 */     ArrayListGrower<StatServiceImp> all = new ArrayListGrower();
/*     */     
/*  43 */     ArrayListGrower<StatServiceRoom> rooms = new ArrayListGrower();
/*     */     
/*  45 */     for (RoomServiceAccess a : RoomServiceAccess.ALL()) {
/*  46 */       rooms.add(new StatServiceRoom((LISTE<StatServiceImp>)all, a, init));
/*     */     }
/*     */     
/*  49 */     this.skinnyDip = new StatServiceSkinny((LISTE<StatServiceImp>)all, init);
/*  50 */     this.bench = new StatServiceBench((LISTE<StatServiceImp>)all, init);
/*  51 */     this.ROOMS = (LIST<StatServiceRoom>)rooms;
/*     */     
/*  53 */     this.hospital = new StatServiceHospital((LISTE<StatServiceImp>)all, (SETT.ROOMS()).HOSPITAL, init);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  62 */     ArrayListGrower<StatServiceChild> nurs = new ArrayListGrower();
/*  63 */     for (ROOM_NURSERY s : (SETT.ROOMS()).NURSERIES) {
/*  64 */       nurs.add(new StatServiceChild((LISTE<StatServiceImp>)all, (RoomBlueprintIns<?>)s, init));
/*     */     }
/*  66 */     this.nurseries = (LIST<StatServiceChild>)nurs;
/*     */     
/*  68 */     this.ALL = (LIST<StatServiceImp>)all;
/*     */ 
/*     */     
/*  71 */     while (this.needMap.hasRoom()) {
/*  72 */       this.needMap.add(new ArrayListGrower());
/*     */     }
/*  74 */     for (StatServiceImp s : this.ALL) {
/*     */       
/*  76 */       if (s.need != null) {
/*  77 */         this.needTot[s.need.index()] = this.needTot[s.need.index()] + s.usage;
/*  78 */         ((ArrayListGrower)this.needMap.get(s.need.index())).add(s);
/*  79 */         this.allNeeds.add(s);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<StatService> perNeed(NEED n) {
/*  91 */     if (this.shrine == null)
/*  92 */       this.shrine = (LIST<StatService>)new ArrayList((STATS.RELIGION()).SHRINE); 
/*  93 */     if (this.temple == null)
/*  94 */       this.temple = (LIST<StatService>)new ArrayList((STATS.RELIGION()).TEMPLE); 
/*  95 */     if (n == (NEEDS.TYPES()).SHRINE)
/*  96 */       return this.shrine; 
/*  97 */     if (n == (NEEDS.TYPES()).TEMPLE)
/*  98 */       return this.temple; 
/*  99 */     return (LIST<StatService>)this.needMap.get(n.index());
/*     */   }
/*     */   
/*     */   public LIST<StatServiceImp> allNeeds() {
/* 103 */     return (LIST<StatServiceImp>)this.allNeeds;
/*     */   }
/*     */   
/*     */   public double needTot(NEED n) {
/* 107 */     return this.needTot[n.index()];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\service\StatsService.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */