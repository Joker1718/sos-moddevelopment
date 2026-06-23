/*     */ package settlement.room.service.food.eatery;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import init.resources.ResGEat;
/*     */ import init.type.NEED;
/*     */ import init.type.NEEDS;
/*     */ import java.io.IOException;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_EATERY extends RoomBlueprintIns<EateryInstance> implements ROOM_EMPLOY_AUTO, RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER {
/*  32 */   private static CharSequence ¤¤food = "food";
/*     */   static {
/*  34 */     D.ts(ROOM_EATERY.class);
/*     */   }
/*     */ 
/*     */   
/*     */   final Constructor constructor;
/*     */   final RoomServiceAccess service;
/*     */   final RoomDistribution dist;
/*     */   
/*     */   public ROOM_EATERY(String key, int index, RoomInitData data, RoomCategorySub cat) throws IOException {
/*  43 */     super(index, data, key, cat);
/*  44 */     this.constructor = new Constructor(this, data);
/*     */     
/*  46 */     this.service = new RoomServiceAccess((RoomBlueprintImp)this, data, (NEED)(NEEDS.TYPES()).HUNGER)
/*     */       {
/*     */         public FSERVICE service(int tx, int ty)
/*     */         {
/*  50 */           return ROOM_EATERY.this.dist.service(tx, ty);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  55 */     RBIT.RBITImp bits = new RBIT.RBITImp();
/*  56 */     for (ResGEat g : RESOURCES.EDI().all()) {
/*  57 */       if (g.serve) {
/*  58 */         bits.or(g.resource);
/*     */       }
/*     */     } 
/*     */     
/*  62 */     this.dist = new RoomDistribution(this, this, RESOURCES.EDI().res(), bits, 4)
/*     */       {
/*     */         protected boolean isPref(RESOURCE r, Race race)
/*     */         {
/*  66 */           return (race.pref()).foodMask.has(r);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean isDeposit(int tx, int ty) {
/*  71 */           return ROOM_EATERY.this.constructor.isDeposit(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean isCrate(int tx, int ty) {
/*  76 */           return ROOM_EATERY.this.constructor.isCrate(tx, ty);
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
/*     */   public Furnisher constructor() {
/*  90 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  95 */     return this.service.finder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/* 103 */     this.service.saver.save(saveFile);
/* 104 */     this.dist.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 109 */     this.service.saver.load(saveFile);
/* 110 */     this.dist.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 115 */     this.service.saver.clear();
/* 116 */     this.dist.clear();
/*     */   }
/*     */   
/*     */   public long totalFood() {
/* 120 */     return this.dist.tStored.total.get();
/*     */   }
/*     */   
/*     */   public long amount(ResG e) {
/* 124 */     return (this.dist.stored(e.resource)).total.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 129 */     this.dist.appendView(mm, ¤¤food);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean autoEmploy(Room r) {
/* 134 */     return ((EateryInstance)r).autoE;
/*     */   }
/*     */ 
/*     */   
/*     */   public void autoEmploy(Room r, boolean b) {
/* 139 */     ((EateryInstance)r).autoE = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceAccess service() {
/* 144 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public int eat(LIST<ResG> prefs, int amount, int tx, int ty) {
/* 149 */     return this.dist.consume(prefs, amount, tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean registersEnvironment() {
/* 154 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\eatery\ROOM_EATERY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */