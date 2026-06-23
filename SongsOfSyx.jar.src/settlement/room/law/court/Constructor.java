/*     */ package settlement.room.law.court;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSprite1xN;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.room.sprite.RoomSpriteImp;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_COURT blue;
/*  29 */   final FurnisherStat prisoners = (FurnisherStat)new FurnisherStat.FurnisherStatI(this, 1);
/*  30 */   final FurnisherStat workers = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*  31 */   final FurnisherStat spectators = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*     */   
/*     */   static final int codeWork = 1;
/*     */   
/*     */   static final int codeCriminal = 2;
/*     */   static final int codeSpectator = 3;
/*     */   static final int distance = 4;
/*     */   
/*     */   protected Constructor(ROOM_COURT blue, RoomInitData init) throws IOException {
/*  40 */     super(init, 2, 3, 88, 44);
/*  41 */     this.blue = blue;
/*  42 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  44 */     station(sp);
/*  45 */     bench(sp);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void station(Json sp) throws IOException {
/*  51 */     final RoomSpriteCombo table = new RoomSpriteCombo(sp, "TABLE_COMBO")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  55 */           return (item.sprite(rx, ry) == this);
/*     */         }
/*     */       };
/*  58 */     RoomSpriteCombo roomSpriteCombo2 = new RoomSpriteCombo(sp, "CARPET_COMBO")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  62 */           return (item.sprite(rx, ry) == this);
/*     */         }
/*     */       };
/*  65 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "TORCH_1X1", sp)
/*     */       {
/*     */         final RoomSprite1x1 top;
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  71 */           super.render(r, s, data, it, degrade, isCandle);
/*  72 */           if (!isCandle) {
/*  73 */             this.top.renderRandom(r, s, it, it.ran(), degrade);
/*     */           }
/*  75 */           return false;
/*     */         }
/*     */       };
/*  78 */     RoomSpriteCombo roomSpriteCombo3 = new RoomSpriteCombo(sp, "STAND_COMBO")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  82 */           return (item.sprite(rx, ry) == this);
/*     */         }
/*     */       };
/*     */     
/*  86 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "CHAIR_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  89 */           return (item.sprite(rx, ry) == table);
/*     */         }
/*     */       };
/*     */     
/*  93 */     RoomSpriteImp roomSpriteImp1 = (new RoomSprite1x1(sp, "DECOR_A_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  96 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 1);
/*     */         }
/*  98 */       }).sData(1);
/*     */     
/* 100 */     RoomSpriteImp roomSpriteImp2 = (new RoomSprite1x1(sp, "DECOR_B_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 103 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 1);
/*     */         }
/* 105 */       }).sData(1);
/*     */     
/* 107 */     FurnisherItemTile xx = new FurnisherItemTile(
/* 108 */         this, 
/* 109 */         (RoomSprite)roomSpriteCombo1, 
/* 110 */         AVAILABILITY.ROOM_SOLID, false);
/* 111 */     FurnisherItemTile cc = new FurnisherItemTile(
/* 112 */         this, 
/* 113 */         (RoomSprite)roomSpriteCombo2, 
/* 114 */         AVAILABILITY.AVOID_PASS, false);
/* 115 */     FurnisherItemTile ca = new FurnisherItemTile(
/* 116 */         this, 
/* 117 */         (RoomSprite)roomSprite1x11, 
/* 118 */         AVAILABILITY.ROOM_SOLID, true);
/* 119 */     FurnisherItemTile ii = (new FurnisherItemTile(
/* 120 */         this, 
/* 121 */         (RoomSprite)roomSprite1x12, 
/* 122 */         AVAILABILITY.AVOID_PASS, false)).setData(1);
/* 123 */     FurnisherItemTile pp = (new FurnisherItemTile(
/* 124 */         this, 
/* 125 */         true, 
/* 126 */         (RoomSprite)roomSpriteCombo3, 
/* 127 */         AVAILABILITY.AVOID_PASS, false)).setData(2);
/* 128 */     FurnisherItemTile dd = new FurnisherItemTile(
/* 129 */         this, 
/* 130 */         (RoomSprite)roomSpriteImp1, 
/* 131 */         AVAILABILITY.ROOM_SOLID, false);
/* 132 */     FurnisherItemTile dc = new FurnisherItemTile(
/* 133 */         this, 
/* 134 */         (RoomSprite)roomSpriteImp2, 
/* 135 */         AVAILABILITY.ROOM_SOLID, false);
/*     */     
/* 137 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 138 */         this, 
/* 139 */         null, 
/* 140 */         AVAILABILITY.ROOM, false);
/*     */     
/* 142 */     FurnisherItemTile _r = new FurnisherItemTile(
/* 143 */         this, 
/* 144 */         true, 
/* 145 */         null, 
/* 146 */         AVAILABILITY.ROOM, false);
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
/* 158 */     flush(3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void bench(Json sp) throws IOException {
/* 164 */     RoomSprite1xN roomSprite1xN1 = new RoomSprite1xN(sp, "BENCH_A_1X1", true);
/* 165 */     RoomSprite1xN roomSprite1xN2 = new RoomSprite1xN(sp, "BENCH_B_1X1", false);
/* 166 */     RoomSprite1xN roomSprite1xN3 = new RoomSprite1xN(sp, "BENCH_C_1X1", false);
/*     */     
/* 168 */     RoomSprite1x1 roomSprite1x1 = new RoomSprite1x1(sp, "TORCH_1X1");
/*     */     
/* 170 */     FurnisherItemTile ss = (new FurnisherItemTile(
/* 171 */         this, 
/* 172 */         true, 
/* 173 */         (RoomSprite)roomSprite1xN1, 
/* 174 */         AVAILABILITY.PENALTY4, false)).setData(3);
/* 175 */     FurnisherItemTile sc = (new FurnisherItemTile(
/* 176 */         this, 
/* 177 */         true, 
/* 178 */         (RoomSprite)roomSprite1xN2, 
/* 179 */         AVAILABILITY.PENALTY4, false)).setData(3);
/* 180 */     FurnisherItemTile se = (new FurnisherItemTile(
/* 181 */         this, 
/* 182 */         true, 
/* 183 */         (RoomSprite)roomSprite1xN3, 
/* 184 */         AVAILABILITY.PENALTY4, false)).setData(3);
/* 185 */     FurnisherItemTile ca = new FurnisherItemTile(
/* 186 */         this, 
/* 187 */         (RoomSprite)roomSprite1x1, 
/* 188 */         AVAILABILITY.ROOM_SOLID, true);
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
/* 217 */     flush(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 223 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 228 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 233 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 239 */     return (Room)new CourtInstance(this.blue, area, init);
/*     */   }
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 243 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 248 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\court\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */