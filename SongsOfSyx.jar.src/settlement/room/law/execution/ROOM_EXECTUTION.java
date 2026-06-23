/*     */ package settlement.room.law.execution;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.law.PUNISHMENT_SERVICE;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.ROOM_ACTIVITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ROOM_EXECTUTION
/*     */   extends RoomBlueprintImp
/*     */   implements PUNISHMENT_SERVICE, ROOM_ACTIVITY.ROOM_ACTIVITY_HASER
/*     */ {
/*     */   final SFinderRoomService data;
/*     */   final Constructor constructor;
/*  29 */   public final ExecutionStation stations = new ExecutionStation(this);
/*     */   final ExecutionSingle instance;
/*     */   
/*     */   public ROOM_EXECTUTION(RoomInitData init, RoomCategorySub block) throws IOException {
/*  33 */     super(init, 0, "_EXECUTION", block);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     this.spec = new ROOM_ACTIVITY()
/*     */       {
/*  97 */         private Coo coo = new Coo();
/*     */ 
/*     */         
/*     */         public SFinderRoomService finder() {
/* 101 */           return ROOM_EXECTUTION.this.data;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE lookAt(int sx, int sy) {
/* 106 */           this.coo.set((sx * 64 + 32), (sy * 64 + 32));
/* 107 */           return (COORDINATE)this.coo;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int sx, int sy) {
/* 112 */           return ROOM_EXECTUTION.this.is(sx, sy);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean shouldCheer(int sx, int sy) {
/* 117 */           ExecutionStation.Client s = ROOM_EXECTUTION.this.stations.client(sx, sy);
/* 118 */           if (s != null) {
/* 119 */             return s.clientBeingExecuted();
/*     */           }
/* 121 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean shouldBoo(int sx, int sy) {
/* 126 */           ExecutionStation.Guard s = ROOM_EXECTUTION.this.stations.guard(sx, sy);
/* 127 */           if (s != null) {
/* 128 */             return s.shouldExecute();
/*     */           }
/* 130 */           return false;
/*     */         }
/*     */         
/*     */         public boolean isActive(int sx, int sy)
/*     */         {
/* 135 */           ExecutionStation.Client s = ROOM_EXECTUTION.this.stations.client(sx, sy);
/* 136 */           return (s != null && s.clientPresent());
/*     */         }
/*     */       };
/*     */     this.instance = new ExecutionSingle(init.m, (RoomBlueprint)this);
/*     */     this.constructor = new Constructor(this, init);
/*     */     this.data = new SFinderRoomService("Execution") { public FSERVICE get(int tx, int ty) {
/*     */           return ROOM_EXECTUTION.this.stations.service(tx, ty);
/*     */         } }
/*     */       ;
/*     */   }
/*     */   private final ROOM_ACTIVITY spec;
/*     */   
/*     */   public ROOM_ACTIVITY spec() {
/* 149 */     return this.spec;
/*     */   }
/*     */   
/*     */   protected void update(double ds) {}
/*     */   
/*     */   public Furnisher constructor() {
/*     */     return this.constructor;
/*     */   }
/*     */   
/*     */   public int punishUsed() {
/*     */     return this.stations.total() - this.stations.available();
/*     */   }
/*     */   
/*     */   public int punishTotal() {
/*     */     return this.stations.total();
/*     */   }
/*     */   
/*     */   protected void save(FilePutter f) {
/*     */     this.stations.save(f);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter f) throws IOException {
/*     */     this.stations.load(f);
/*     */   }
/*     */   
/*     */   protected void clear() {
/*     */     this.stations.clear();
/*     */   }
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*     */     return this.data;
/*     */   }
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*     */     mm.add(new Gui(this));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\execution\ROOM_EXECTUTION.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */