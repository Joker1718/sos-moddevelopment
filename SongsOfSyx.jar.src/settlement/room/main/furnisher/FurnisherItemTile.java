/*    */ package settlement.room.main.furnisher;
/*    */ 
/*    */ import settlement.path.AVAILABILITY;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import snake2d.util.map.MAP_BOOLEAN;
/*    */ import snake2d.util.sets.INDEXED;
/*    */ 
/*    */ public class FurnisherItemTile
/*    */   implements INDEXED {
/*    */   private final int index;
/*    */   public final boolean canGoCandle;
/*    */   public final RoomSprite sprite;
/*    */   public final AVAILABILITY availability;
/*    */   public final boolean mustBeReachable;
/*    */   public boolean noWalls;
/*    */   private int data;
/*    */   
/*    */   public FurnisherItemTile(Furnisher p, boolean mustBeReachable, RoomSprite sprite, AVAILABILITY availability, boolean canGoCandle) {
/* 19 */     this.index = p.tiles.add(this);
/* 20 */     this.canGoCandle = canGoCandle;
/* 21 */     this.sprite = sprite;
/* 22 */     this.availability = availability;
/* 23 */     this.mustBeReachable = mustBeReachable;
/*    */   }
/*    */   
/*    */   public FurnisherItemTile(Furnisher p, RoomSprite sprite, AVAILABILITY availability, boolean canGoCandle) {
/* 27 */     this(p, false, sprite, availability, canGoCandle);
/*    */   }
/*    */   
/*    */   public boolean isBlocker() {
/* 31 */     return !(this.availability.player >= 0.0D && this.availability.from <= 0.0D);
/*    */   }
/*    */   
/*    */   public boolean isNotBlocker() {
/* 35 */     return (!isBlocker() && this.availability.player <= AVAILABILITY.ROOM.player);
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry) {
/* 40 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 45 */     return this.index;
/*    */   }
/*    */   
/*    */   public FurnisherItemTile setData(int data) {
/* 49 */     this.data = data;
/* 50 */     return this;
/*    */   }
/*    */   
/*    */   public int data() {
/* 54 */     return this.data;
/*    */   }
/*    */   
/*    */   public RoomSprite sprite() {
/* 58 */     return this.sprite;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\furnisher\FurnisherItemTile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */