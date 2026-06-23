/*     */ package settlement.room.service.pleasure;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.room.service.module.RoomServiceNeed;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_PLEASURE extends RoomBlueprintIns<PleasureInstance> implements ROOM_EMPLOY_AUTO, RoomServiceNeed.ROOM_SERVICE_NEED_HASER {
/*     */   public static final String TYPE = "PLEASURE";
/*     */   final Constructor constructor;
/*     */   final ABed bed;
/*     */   final RoomServiceNeed service;
/*     */   
/*     */   public ROOM_PLEASURE(String key, int tindex, RoomInitData init, RoomCategorySub block) throws IOException {
/*  28 */     super(tindex, init, key, block);
/*  29 */     this.bed = new ABed(this);
/*  30 */     this.constructor = new Constructor(this, init);
/*  31 */     this.service = new RoomServiceNeed((RoomBlueprintImp)this, init)
/*     */       {
/*     */         public FSERVICE service(int tx, int ty)
/*     */         {
/*  35 */           if (ROOM_PLEASURE.this.bed.init(tx, ty) != null)
/*  36 */             return ROOM_PLEASURE.this.bed.service; 
/*  37 */           return null;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  55 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  60 */     this.service.saver.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*  65 */     this.service.saver.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/*  70 */     this.service.saver.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean autoEmploy(Room r) {
/*  75 */     return ((PleasureInstance)r).auto;
/*     */   }
/*     */ 
/*     */   
/*     */   public void autoEmploy(Room r, boolean b) {
/*  80 */     ((PleasureInstance)r).auto = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderFindable service(int tx, int ty) {
/*  85 */     if (this.bed.init(tx, ty) != null)
/*  86 */       return (SFinderFindable)this.service.finder; 
/*  87 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceNeed service() {
/*  92 */     return this.service;
/*     */   }
/*     */   
/*     */   public boolean clientShouldUndress(int tx, int ty) {
/*  96 */     if (this.bed.init(tx, ty) != null) {
/*  97 */       return this.bed.clientShouldUndress();
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public void clientUndress(int tx, int ty) {
/* 103 */     if (this.bed.init(tx, ty) != null) {
/* 104 */       this.bed.clientUndress();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean workerReadyShouldUndress(int tx, int ty) {
/* 109 */     if (this.bed.init(tx, ty) != null) {
/* 110 */       return this.bed.workerReadyShouldUndress();
/*     */     }
/* 112 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\pleasure\ROOM_PLEASURE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */