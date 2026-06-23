/*     */ package settlement.room.main.placement;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableMessages;
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
/*     */ public class PLACEMENT
/*     */ {
/*     */   public final RoomPlacer placer;
/*     */   private final Instance instance;
/*     */   public final MAP_BOOLEAN embryo;
/*     */   public final RoomBlueprint factory;
/*     */   
/*     */   public PLACEMENT(ROOMS m) {
/*  38 */     this.factory = new RoomBlueprint("_PLACEMENT")
/*     */       {
/*     */ 
/*     */         
/*     */         protected void update(double ds)
/*     */         {
/*  44 */           PLACEMENT.this.placer.update(ds);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public SFinderRoomService service(int tx, int ty) {
/*  50 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void save(FilePutter saveFile) {}
/*     */ 
/*     */ 
/*     */         
/*     */         protected void load(FileGetter saveFile) throws IOException {
/*  61 */           PLACEMENT.this.placer.load();
/*  62 */           PLACEMENT.this.placer.structure.read();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clear() {
/*  68 */           PLACEMENT.this.placer.init(null, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public COLOR miniC(int tx, int ty) {
/*  73 */           return COLOR.BLUE50;
/*     */         }
/*     */ 
/*     */         
/*     */         public COLOR miniCPimped(ColorImp origional, int tx, int ty, boolean northern, boolean southern) {
/*  78 */           return (COLOR)origional;
/*     */         }
/*     */       };
/*     */     this.instance = new Instance(m, this.factory);
/*     */     this.placer = new RoomPlacer(this, this.instance);
/*     */     this.embryo = (MAP_BOOLEAN)this.instance;
/*     */   } public boolean canReconstruct(int tx, int ty) {
/*  85 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/*  86 */     if (r != null && r.constructor() != null && r.constructor().usesArea())
/*  87 */       return true; 
/*  88 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static CharSequence placable(int tx, int ty, RoomBlueprintImp blue, boolean buildOnWalls) {
/*  93 */     if (!SETT.IN_BOUNDS(tx, ty))
/*  94 */       return PlacableMessages.¤¤TERRAIN_BLOCK; 
/*  95 */     if ((SETT.ROOMS()).placement.factory.is(tx, ty))
/*  96 */       return PLACABLE.E; 
/*  97 */     if ((SETT.ROOMS()).map.is(tx, ty)) {
/*  98 */       return PlacableMessages.¤¤ROOM_BLOCK;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 103 */     if (SETT.TERRAIN().get(tx, ty).clearing().isEasilyCleared()) {
/* 104 */       return null;
/*     */     }
/* 106 */     if (SETT.TERRAIN().get(tx, ty).clearing().isStructure()) {
/* 107 */       if (!blue.constructor().removeTerrain(tx, ty))
/* 108 */         return null; 
/* 109 */       if (!buildOnWalls && !SETT.TERRAIN().get(tx, ty).roofIs())
/* 110 */         return PlacableMessages.¤¤TERRAIN_BLOCK; 
/* 111 */       if (blue.constructor().mustBeIndoors()) {
/* 112 */         if (SETT.TERRAIN().get(tx, ty).roofIs())
/* 113 */           return null; 
/* 114 */         if ((SETT.TERRAIN().get(tx, ty).clearing().can() || (SETT.TERRAIN()).MOUNTAIN.is(tx, ty)) && buildOnWalls)
/* 115 */           return null; 
/* 116 */         return PlacableMessages.¤¤TERRAIN_BLOCK;
/* 117 */       }  if (blue.constructor().mustBeOutdoors()) {
/* 118 */         if (!(SETT.TERRAIN()).MOUNTAIN.is(tx, ty) && SETT.TERRAIN().get(tx, ty).clearing().can() && buildOnWalls)
/* 119 */           return null; 
/* 120 */         return PlacableMessages.¤¤TERRAIN_BLOCK;
/*     */       } 
/* 122 */       if (SETT.TERRAIN().get(tx, ty).roofIs())
/* 123 */         return null; 
/* 124 */       if ((SETT.TERRAIN().get(tx, ty).clearing().can() || (SETT.TERRAIN()).MOUNTAIN.is(tx, ty)) && buildOnWalls) {
/* 125 */         return null;
/*     */       }
/*     */     }
/* 128 */     else if (SETT.TERRAIN().get(tx, ty).clearing().can() && ((SETT.PATH()).availability.get(tx, ty)).player > 0.0D) {
/* 129 */       return null;
/* 130 */     }  return PlacableMessages.¤¤TERRAIN_BLOCK;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\PLACEMENT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */