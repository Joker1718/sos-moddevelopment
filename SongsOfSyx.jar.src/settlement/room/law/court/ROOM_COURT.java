/*     */ package settlement.room.law.court;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.law.PUNISHMENT_SERVICE;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.room.service.module.RoomServiceNeed;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_COURT
/*     */   extends RoomBlueprintIns<CourtInstance> implements RoomServiceNeed.ROOM_SERVICE_NEED_HASER, PUNISHMENT_SERVICE {
/*     */   public static final double freeRate = 0.2D;
/*     */   final RoomServiceNeed data;
/*     */   final Constructor constructor;
/*     */   private int executions;
/*     */   private int total;
/*     */   
/*     */   public ROOM_COURT(RoomInitData init, RoomCategorySub block) throws IOException {
/*  33 */     super(0, init, "_COURT", block);
/*     */     
/*  35 */     this.data = new RoomServiceNeed((RoomBlueprintImp)this, init)
/*     */       {
/*     */         public FSERVICE service(int tx, int ty) {
/*  38 */           return Service.init(tx, ty);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  43 */     this.constructor = new Constructor(this, init);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  56 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public int punishUsed() {
/*  61 */     return this.executions;
/*     */   }
/*     */ 
/*     */   
/*     */   public int punishTotal() {
/*  66 */     return this.total;
/*     */   }
/*     */ 
/*     */   
/*     */   void incPrisoners(int current, int total) {
/*  71 */     this.executions += current;
/*  72 */     this.total += total;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter f) {
/*  78 */     f.i(this.executions);
/*  79 */     f.i(this.total);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter f) throws IOException {
/*  84 */     this.executions = f.i();
/*  85 */     this.total = f.i();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/*  90 */     this.executions = 0;
/*  91 */     this.total = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  96 */     return this.data.finder;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {}
/*     */ 
/*     */   
/*     */   public CourtStation exectuionReserve() {
/* 105 */     if (this.executions == this.total)
/* 106 */       return null; 
/* 107 */     int i = RND.rInt(instancesSize());
/* 108 */     for (int k = 0; k < instancesSize(); k++) {
/* 109 */       CourtInstance ins = (CourtInstance)getInstance((k + i) % instancesSize());
/* 110 */       if (ins.active() && ins.executions() < ins.total()) {
/* 111 */         return ins.reserveSpot();
/*     */       }
/*     */     } 
/* 114 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public CourtStation executionSpot(COORDINATE c) {
/* 118 */     if (is(c)) {
/* 119 */       return CourtStation.init(c.x(), c.y());
/*     */     }
/* 121 */     return null;
/*     */   }
/*     */   
/*     */   public CourtStation workReserve(Room r) {
/* 125 */     CourtInstance ins = (CourtInstance)r;
/* 126 */     return ins.work();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldCheer(int tx, int ty) {
/* 132 */     CourtInstance ins = (CourtInstance)this.getter.get(tx, ty);
/* 133 */     return (ins != null && ins.executions() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceNeed service() {
/* 138 */     return this.data;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\court\ROOM_COURT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */