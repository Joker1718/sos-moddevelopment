/*     */ package settlement.room.infra.inn;
/*     */ 
/*     */ import game.tourism.Review;
/*     */ import init.type.NEED;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
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
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_INN
/*     */   extends RoomBlueprintIns<InnInstance> implements ROOM_EMPLOY_AUTO, RoomService.ROOM_SERVICE_HASER {
/*     */   final Constructor constructor;
/*     */   final ABed bed;
/*     */   final RoomService service;
/*     */   
/*     */   public ROOM_INN(RoomInitData init, RoomCategorySub block) throws IOException {
/*  30 */     super(0, init, "_INN", block);
/*  31 */     this.bed = new ABed(this);
/*  32 */     this.constructor = new Constructor(this, init);
/*  33 */     this.service = new RoomService((RoomBlueprintImp)this, init, null)
/*     */       {
/*     */         public FSERVICE service(int tx, int ty)
/*     */         {
/*  37 */           if (ROOM_INN.this.bed.init(tx, ty) != null)
/*  38 */             return ROOM_INN.this.bed.service; 
/*  39 */           return null;
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
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*  52 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  57 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/*  62 */     this.service.saver.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*  67 */     this.service.saver.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/*  72 */     this.service.saver.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean autoEmploy(Room r) {
/*  77 */     return ((InnInstance)r).auto;
/*     */   }
/*     */ 
/*     */   
/*     */   public void autoEmploy(Room r, boolean b) {
/*  82 */     ((InnInstance)r).auto = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderFindable service(int tx, int ty) {
/*  87 */     if (this.bed.init(tx, ty) != null)
/*  88 */       return (SFinderFindable)this.service.finder; 
/*  89 */     return null;
/*     */   }
/*     */   
/*     */   public DIR sleepDir(int tx, int ty) {
/*  93 */     for (DIR d : DIR.ORTHO) {
/*  94 */       if ((SETT.ROOMS()).fData.tileData.is(tx, ty, d, 1))
/*  95 */         return d; 
/*     */     } 
/*  97 */     return DIR.C;
/*     */   }
/*     */   
/*     */   public void setReview(int tx, int ty, Review rev) {
/* 101 */     InnInstance ins = (InnInstance)get(tx, ty);
/* 102 */     Review f = ins.reviews[ins.reviews.length - 1];
/* 103 */     for (int i = ins.reviews.length - 1; i > 0; i--)
/* 104 */       ins.reviews[i] = ins.reviews[i - 1]; 
/* 105 */     ins.reviews[0] = f;
/* 106 */     f.copyOther(rev);
/* 107 */     ins.earnings += rev.credits;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomService service() {
/* 112 */     return this.service;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\inn\ROOM_INN.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */