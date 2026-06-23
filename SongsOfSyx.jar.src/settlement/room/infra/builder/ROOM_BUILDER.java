/*     */ package settlement.room.infra.builder;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.job.ROOM_RADIUS;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import view.tool.PlacableMessages;
/*     */ 
/*     */ 
/*     */ public final class ROOM_BUILDER
/*     */   extends RoomBlueprintIns<BuilderInstance>
/*     */   implements ROOM_RADIUS.ROOM_RADIUSE
/*     */ {
/*     */   private final Furnisher constructor;
/*     */   
/*     */   public ROOM_BUILDER(RoomInitData init, RoomCategorySub cat) throws IOException {
/*  36 */     super(0, init, "_BUILDER", cat);
/*  37 */     this.constructor = new Furnisher(init, 0, 0, 88, 72, init)
/*     */       {
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
/*     */         public boolean usesArea()
/*     */         {
/*  52 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean mustBeIndoors() {
/*  57 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public Room create(TmpArea area, RoomInit init) {
/*  62 */           return (Room)new BuilderInstance(ROOM_BUILDER.this, area, init);
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence placable(int tx, int ty, FurnisherItem item, FurnisherItemTile tile) {
/*  67 */           if (SETT.TERRAIN().get(tx, ty).roofIs())
/*  68 */             return super.placable(tx, ty, item, tile); 
/*  69 */           if (SETT.TERRAIN().get(tx, ty) != (SETT.TERRAIN()).NADA && !SETT.TERRAIN().get(tx, ty).clearing().isEasilyCleared()) {
/*  70 */             return PlacableMessages.¤¤TERRAIN_BLOCK;
/*     */           }
/*  72 */           return super.placable(tx, ty, item, tile);
/*     */         }
/*     */ 
/*     */         
/*     */         public RoomBlueprintImp blue() {
/*  77 */           return (RoomBlueprintImp)ROOM_BUILDER.this;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean needFlooring() {
/*  82 */           return false;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
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
/*     */   
/*     */   public Furnisher constructor() {
/* 100 */     return this.constructor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/* 106 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void saveP(FilePutter saveFile) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadP(FileGetter saveFile) throws IOException {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearP() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean degrades() {
/* 126 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_RADIUS.ROOM_RADIUS_INSTANCE radiusInstance(Room t) {
/* 131 */     return (BuilderInstance)t;
/*     */   }
/*     */   
/*     */   public void reset(RoomInstance ins) {
/* 135 */     if (ins == null)
/*     */       return; 
/* 137 */     if (ins instanceof BuilderInstance) {
/* 138 */       BuilderInstance b = (BuilderInstance)ins;
/* 139 */       b.failHour = (byte)(TIME.hours().bitCurrent() - 1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\builder\ROOM_BUILDER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */