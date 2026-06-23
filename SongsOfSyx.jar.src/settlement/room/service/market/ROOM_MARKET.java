/*     */ package settlement.room.service.market;
/*     */ import game.GAME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.race.RaceResources;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.ResG;
/*     */ import init.type.NEED;
/*     */ import init.type.NEEDS;
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
/*     */ import settlement.room.service.food.eatery.RoomDistribution;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_MARKET extends RoomBlueprintIns<MarketInstance> implements ROOM_EMPLOY_AUTO, RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER {
/*  34 */   private static CharSequence ¤¤food = "wares"; final Constructor constructor;
/*     */   static {
/*  36 */     D.ts(ROOM_MARKET.class);
/*     */   }
/*     */   
/*     */   final RoomServiceAccess service;
/*     */   RoomDistribution dist;
/*     */   
/*     */   public ROOM_MARKET(String key, int index, RoomInitData data, RoomCategorySub cat) throws IOException {
/*  43 */     super(index, data, key, cat);
/*     */     
/*  45 */     this.constructor = new Constructor(this, data);
/*     */     
/*  47 */     this.service = new RoomServiceAccess((RoomBlueprintImp)this, data, (NEED)(NEEDS.TYPES()).SHOPPING)
/*     */       {
/*     */         public FSERVICE service(int tx, int ty)
/*     */         {
/*  51 */           return ROOM_MARKET.this.dist.service(tx, ty);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  56 */     GAME.addOnInit(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  60 */             ArrayListGrower<RESOURCE> ress = new ArrayListGrower();
/*  61 */             RBIT.RBITImp bits = new RBIT.RBITImp();
/*     */             
/*  63 */             for (RaceResources.RaceResource r : (RACES.res()).ALL) {
/*  64 */               ress.add(r.res);
/*  65 */               bits.or(r.res.bit);
/*     */             } 
/*     */             
/*  68 */             ROOM_MARKET.this.dist = new RoomDistribution(ROOM_MARKET.this, ROOM_MARKET.this, (LIST)ress, bits, 1)
/*     */               {
/*     */                 protected boolean isPref(RESOURCE r, Race race)
/*     */                 {
/*  72 */                   return false;
/*     */                 }
/*     */ 
/*     */                 
/*     */                 protected boolean isDeposit(int tx, int ty) {
/*  77 */                   return (ROOM_MARKET.null.access$0(ROOM_MARKET.null.this)).constructor.isStore(tx, ty);
/*     */                 }
/*     */ 
/*     */                 
/*     */                 protected boolean isCrate(int tx, int ty) {
/*  82 */                   return (ROOM_MARKET.null.access$0(ROOM_MARKET.null.this)).constructor.isCrate(tx, ty);
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
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
/*     */   
/*     */   public Furnisher constructor() {
/* 100 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/* 105 */     return this.service.finder;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {
/* 110 */     this.service.saver.save(saveFile);
/* 111 */     this.dist.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/* 116 */     this.service.saver.load(saveFile);
/* 117 */     this.dist.load(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/* 122 */     this.service.saver.clear();
/* 123 */     this.dist.clear();
/*     */   }
/*     */   
/*     */   public long totalFood() {
/* 127 */     return this.dist.tStored.total.get();
/*     */   }
/*     */   
/*     */   public long amount(ResG e) {
/* 131 */     return (this.dist.stored(e.resource)).total.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 136 */     this.dist.appendView(mm, ¤¤food);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean autoEmploy(Room r) {
/* 141 */     return ((MarketInstance)r).autoE;
/*     */   }
/*     */ 
/*     */   
/*     */   public void autoEmploy(Room r, boolean b) {
/* 146 */     ((MarketInstance)r).autoE = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceAccess service() {
/* 151 */     return this.service;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int buy(RaceResources.RaceResource res, int amount, int tx, int ty) {
/* 157 */     return this.dist.consume(res.res, amount, tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean registersEnvironment() {
/* 162 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\market\ROOM_MARKET.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */