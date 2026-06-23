/*     */ package settlement.room.service.food.tavern;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import init.resources.ResGDrink;
/*     */ import init.type.NEED;
/*     */ import init.type.NEEDS;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
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
/*     */ import settlement.room.service.food.eatery.RoomDistribution;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_TAVERN extends RoomBlueprintIns<TavernInstance> implements RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER, ROOM_EMPLOY_AUTO {
/*  34 */   private static CharSequence ¤¤food = "drinks";
/*     */   static {
/*  36 */     D.ts(ROOM_TAVERN.class);
/*     */   }
/*     */   
/*     */   public final RoomServiceAccess serviceData;
/*     */   final RoomDistribution dist;
/*     */   final Constructor constructor;
/*     */   
/*     */   public ROOM_TAVERN(String key, int index, RoomInitData data, RoomCategorySub cat) throws IOException {
/*  44 */     super(index, data, key, cat);
/*  45 */     this.constructor = new Constructor(this, data);
/*  46 */     this.serviceData = new RoomServiceAccess((RoomBlueprintImp)this, data, (NEED)(NEEDS.TYPES()).THIRST)
/*     */       {
/*     */         public FSERVICE service(int tx, int ty)
/*     */         {
/*  50 */           return ROOM_TAVERN.this.dist.service(tx, ty);
/*     */         }
/*     */       };
/*     */     
/*  54 */     RBIT.RBITImp bits = new RBIT.RBITImp();
/*  55 */     for (ResGDrink g : RESOURCES.DRINKS().all()) {
/*  56 */       if (g.serve) {
/*  57 */         bits.or(g.resource);
/*     */       }
/*     */     } 
/*     */     
/*  61 */     this.dist = new RoomDistribution(this, this, RESOURCES.DRINKS().res(), bits, 4)
/*     */       {
/*     */         protected boolean isPref(RESOURCE r, Race race)
/*     */         {
/*  65 */           return (race.pref()).drinkMask.has(r);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean isDeposit(int tx, int ty) {
/*  70 */           return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == Constructor.ITABLE);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean isCrate(int tx, int ty) {
/*  75 */           return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == Constructor.ISTORAGE);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*  83 */     this.dist.appendView(mm, ¤¤food);
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  88 */     return this.constructor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  99 */     return this.serviceData.finder;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/* 104 */     this.serviceData.saver.save(saveFile);
/* 105 */     this.dist.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 110 */     this.serviceData.saver.load(saveFile);
/* 111 */     this.dist.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 116 */     this.serviceData.saver.clear();
/* 117 */     this.dist.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceAccess service() {
/* 122 */     return this.serviceData;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean autoEmploy(Room r) {
/* 127 */     return ((TavernInstance)r).auto;
/*     */   }
/*     */ 
/*     */   
/*     */   public void autoEmploy(Room r, boolean b) {
/* 132 */     ((TavernInstance)r).auto = b;
/*     */   }
/*     */   
/*     */   public int consume(LIST<ResG> prefs, int amount, int tx, int ty) {
/* 136 */     return this.dist.consume(prefs, amount, tx, ty);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\tavern\ROOM_TAVERN.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */