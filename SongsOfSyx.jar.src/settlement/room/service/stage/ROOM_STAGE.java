/*     */ package settlement.room.service.stage;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.ROOM_SPECTATOR;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.room.service.module.RoomServiceNeed;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_STAGE
/*     */   extends RoomBlueprintIns<StageInstance> implements RoomServiceNeed.ROOM_SERVICE_NEED_HASER, ROOM_SPECTATOR.ROOM_SPECTATOR_HASER {
/*     */   final RoomServiceNeed data;
/*     */   final StageConstructor constructor;
/*     */   final Centre work;
/*     */   private final ROOM_SPECTATOR spec;
/*     */   
/*     */   public ROOM_STAGE(String key, int index, RoomInitData init, RoomCategorySub block) throws IOException {
/*  34 */     super(index, init, key, block);
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
/*  94 */     this.spec = new ROOM_SPECTATOR()
/*     */       {
/*  96 */         private Coo coo = new Coo();
/*     */         
/*  98 */         private final byte[] acts = Alloc.bb(64);
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
/*     */         public RoomServiceAccess service() {
/* 110 */           return (RoomServiceAccess)ROOM_STAGE.this.service();
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE lookAt(int sx, int sy) {
/* 115 */           this.coo.set((sx * 64 + 32), (sy * 64 + 32));
/* 116 */           return (COORDINATE)this.coo;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int sx, int sy) {
/* 121 */           StageInstance ins = (StageInstance)ROOM_STAGE.this.getter.get(sx, sy);
/* 122 */           return (ins != null);
/*     */         }
/*     */         
/*     */         private int activity(int sx, int sy) {
/* 126 */           StageInstance ins = (StageInstance)ROOM_STAGE.this.getter.get(sx, sy);
/* 127 */           if (ins == null)
/* 128 */             return 0; 
/* 129 */           int s = ins.off;
/*     */           
/* 131 */           s += (int)(this.acts.length * TIME.currentSecond() / TIME.secondsPerDay());
/* 132 */           s %= this.acts.length;
/* 133 */           return this.acts[s];
/*     */         } public FSERVICE service(int tx, int ty) {
/*     */           return ROOM_STAGE.this.work.service(tx, ty);
/*     */         }
/*     */         public boolean shouldCheer(int sx, int sy) {
/* 138 */           return (activity(sx, sy) == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean shouldBoo(int sx, int sy) {
/* 143 */           return (activity(sx, sy) == 2);
/*     */         }
/*     */       };
/*     */     this.work = new Centre(this);
/*     */     this.data = new RoomServiceNeed((RoomBlueprintImp)this, init) { public boolean isActive(int sx, int sy) {
/* 148 */           return true;
/*     */         } }
/*     */       ;
/*     */     this.constructor = new StageConstructor(this, init);
/*     */     employment().setShiftStart(ROOM_SPECTATOR.WORK_STARTSD, false);
/*     */   } public ROOM_SPECTATOR spec() {
/* 154 */     return this.spec;
/*     */   }
/*     */   
/*     */   protected void update(double ds) {}
/*     */   
/*     */   public Furnisher constructor() {
/*     */     return this.constructor;
/*     */   }
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*     */     return this.data.finder;
/*     */   }
/*     */   
/*     */   public SFinderRoomService finder() {
/*     */     return this.data.finder;
/*     */   }
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*     */     this.data.saver.save(saveFile);
/*     */   }
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*     */     this.data.saver.load(saveFile);
/*     */   }
/*     */   
/*     */   protected void clearP() {
/*     */     this.data.saver.clear();
/*     */   }
/*     */   
/*     */   public RoomServiceNeed service() {
/*     */     return this.data;
/*     */   }
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\stage\ROOM_STAGE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */