/*    */ package settlement.room.main.construction;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.util.RoomAreaWrapper;
/*    */ import settlement.room.main.util.RoomState;
/*    */ import settlement.tilemap.terrain.TBuilding;
/*    */ import settlement.tilemap.terrain.Terrain;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConstructionInit
/*    */ {
/*    */   public final int upgrade;
/*    */   public final Furnisher b;
/*    */   public final TBuilding structure;
/*    */   public final int degrade;
/*    */   public final RoomState state;
/* 24 */   private static RoomAreaWrapper wrap = new RoomAreaWrapper();
/*    */   
/*    */   public ConstructionInit(int upgrade, Furnisher b, TBuilding structure, int degrade, RoomState state) {
/* 27 */     this.upgrade = upgrade;
/* 28 */     this.structure = structure;
/* 29 */     this.degrade = degrade;
/* 30 */     this.state = state;
/* 31 */     this.b = b;
/*    */   }
/*    */   
/*    */   public ConstructionInit(Room room, int rx, int ry, boolean broken) {
/* 35 */     this(room, rx, ry, (room.degrader(rx, ry) == null) ? 0 : room.degrader(rx, ry).getData(), broken);
/*    */   }
/*    */   
/*    */   private ConstructionInit(Room room, int rx, int ry, int degrade, boolean broken) {
/* 39 */     this(room.upgrade(rx, ry), room.constructor(), findStructure(rx, ry), degrade, room.makeState(rx, ry, broken));
/*    */   }
/*    */ 
/*    */   
/*    */   public static TBuilding findStructure(int rx, int ry) {
/* 44 */     Room room = (SETT.ROOMS()).map.get(rx, ry);
/*    */     
/* 46 */     if (room == null) {
/* 47 */       return null;
/*    */     }
/* 49 */     if (room instanceof ConstructionInstance) {
/* 50 */       return ((ConstructionInstance)room).structure();
/*    */     }
/* 52 */     ROOMA a = wrap.init(room, rx, ry);
/* 53 */     wrap.done();
/* 54 */     for (COORDINATE c : a.body()) {
/* 55 */       if (a.is(c)) {
/* 56 */         Terrain.TerrainTile t = SETT.TERRAIN().get(c.x(), c.y());
/* 57 */         if (t instanceof TBuilding.BuildingComponent) {
/* 58 */           return ((TBuilding.BuildingComponent)SETT.TERRAIN().get(c.x(), c.y())).building();
/*    */         }
/*    */       } 
/*    */     } 
/* 62 */     return (SETT.TERRAIN()).BUILDINGS.MUD;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\construction\ConstructionInit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */