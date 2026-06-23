/*     */ package settlement.room.infra.hauler;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.STOCKPILE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*     */ import settlement.room.main.job.ROOM_RADIUS;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_HAULER
/*     */   extends RoomBlueprintIns<HaulerInstance>
/*     */   implements ROOM_RADIUS.ROOM_RADIUSE, ROOM_EMPLOY_AUTO {
/*     */   private final Furnisher constructor;
/*  32 */   final Crate crate = new Crate(this);
/*  33 */   public final HaulerTally tally = new HaulerTally();
/*     */ 
/*     */   
/*     */   public ROOM_HAULER(RoomInitData init, RoomCategorySub cat) throws IOException {
/*  37 */     super(0, init, "_HAULER", cat);
/*  38 */     this.constructor = new Constructor(init);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/*  49 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  54 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {
/*  64 */     this.tally.clear();
/*  65 */     for (HaulerInstance ins : all()) {
/*  66 */       this.tally.init(ins);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearP() {
/*  72 */     this.tally.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean degrades() {
/*  77 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*  82 */     mm.add((new Gui(this)).make());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean autoEmploy(Room r) {
/*  87 */     return ((HaulerInstance)r).auto;
/*     */   }
/*     */ 
/*     */   
/*     */   public void autoEmploy(Room r, boolean b) {
/*  92 */     ((HaulerInstance)r).auto = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_RADIUS.ROOM_RADIUS_INSTANCE radiusInstance(Room t) {
/*  97 */     return (HaulerInstance)t;
/*     */   }
/*     */   
/*     */   public void removeFromEverywhere(STOCKPILE.StockpileImp stock, FResources.RTYPE record) {
/* 101 */     double[] res = new double[RESOURCES.ALL().size()];
/* 102 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 103 */       double d = stock.get(r) / (1.0D + this.tally.amountReservable.get(r));
/* 104 */       d = CLAMP.d(d, 0.0D, 1.0D);
/* 105 */       res[r.index()] = d;
/*     */     } 
/*     */     
/* 108 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/* 109 */       RoomInstance roomInstance = (SETT.ROOMS()).STOCKPILE.get(c.x(), c.y());
/* 110 */       if (roomInstance == null)
/*     */         continue; 
/* 112 */       RESOURCE_TILE cr = (RESOURCE_TILE)roomInstance.storage(c.x(), c.y());
/* 113 */       if (cr != null && cr.resource() != null && stock.get(cr.resource()) > 0 && res[cr.resource().index()] > 0.0D) {
/* 114 */         int a = (int)Math.ceil(res[cr.resource().index()] * cr.reservable());
/* 115 */         stock.inc(cr.resource(), -a);
/* 116 */         for (int i = 0; i < a; i++) {
/* 117 */           cr.findableReserve();
/* 118 */           cr.resourcePickup();
/*     */         } 
/* 120 */         FACTIONS.player().res().inc(cr.resource(), record, -a);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\ROOM_HAULER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */