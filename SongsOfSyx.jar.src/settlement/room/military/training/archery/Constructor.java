/*     */ package settlement.room.military.training.archery;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.file.Json;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_ARCHERY blue;
/*     */   final FurnisherItemTile plat;
/*     */   
/*  26 */   final FurnisherStat men = new FurnisherStat(this, 0.0D)
/*     */     {
/*     */       public double get(AREA area, double fromItems)
/*     */       {
/*  30 */         return fromItems;
/*     */       }
/*     */ 
/*     */       
/*     */       public GText format(GText t, double value) {
/*  35 */         return GFORMAT.i(t, (int)value);
/*     */       }
/*     */     };
/*     */   
/*     */   protected Constructor(ROOM_ARCHERY blue, RoomInitData init) throws IOException {
/*  40 */     super(init, 1, 1, 88, 44);
/*  41 */     this.blue = blue;
/*     */     
/*  43 */     Json js = init.data().json("SPRITES");
/*     */     
/*  45 */     RoomSprite1x1 sTarget = new RoomSprite1x1(js, "TARGET_1X1");
/*  46 */     RoomSprite1x1 sLane = new RoomSprite1x1(js, "LANE_1X1");
/*  47 */     RoomSprite1x1 sPlat = new RoomSprite1x1(js, "PLATFORM_1X1");
/*  48 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(js, "TABLE_1X1");
/*     */ 
/*     */     
/*  51 */     RoomSpriteCombo roomSpriteCombo = new RoomSpriteCombo(js, "FENCE_COMBO");
/*     */     
/*  53 */     FurnisherItemTile ta = new FurnisherItemTile(this, false, (RoomSprite)sTarget, AVAILABILITY.ROOM_SOLID, false);
/*  54 */     FurnisherItemTile ll = new FurnisherItemTile(this, false, (RoomSprite)sLane, AVAILABILITY.ROOM_SOLID, false);
/*  55 */     FurnisherItemTile pp = new FurnisherItemTile(this, true, (RoomSprite)sPlat, AVAILABILITY.ROOM, false);
/*  56 */     FurnisherItemTile ca = new FurnisherItemTile(this, false, (RoomSprite)roomSprite1x11, AVAILABILITY.ROOM_SOLID, true);
/*  57 */     FurnisherItemTile __ = new FurnisherItemTile(this, false, (RoomSprite)roomSpriteCombo, AVAILABILITY.ROOM_SOLID, false);
/*  58 */     this.plat = pp;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 196 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 201 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 206 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 211 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_ARCHERY blue() {
/* 216 */     return this.blue;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\archery\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */