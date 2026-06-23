/*     */ package settlement.room.home.chamber;
/*     */ 
/*     */ import init.sprite.game.Sheets;
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
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_CHAMBER blue;
/*     */   final FurnisherStat servants;
/*     */   final FurnisherStat users;
/*     */   final FurnisherItemTile bb;
/*  33 */   final int WORK_NEEDED = 22;
/*     */ 
/*     */ 
/*     */   
/*     */   protected Constructor(final ROOM_CHAMBER blue, RoomInitData init) throws IOException {
/*  38 */     super(init, 1, 2, 88, 44);
/*  39 */     this.blue = blue;
/*  40 */     this.servants = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*  41 */     this.users = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*     */     
/*  43 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  45 */     final RoomSprite1x1 snick = new RoomSprite1x1(sp, "MISC_1X1");
/*     */ 
/*     */     
/*  48 */     RoomSpriteXxX roomSpriteXxX1 = new RoomSpriteXxX(2)
/*     */       {
/*     */         public Sheets sheet(RenderData.RenderIterator it)
/*     */         {
/*  52 */           ChamberInstance ins = (ChamberInstance)blue.get(it.tx(), it.ty());
/*  53 */           if (ins != null && ins.occupant() != null)
/*  54 */             return (ins.occupant().race().home().clas(ins.occupant().indu())).masterBed.get(ins); 
/*  55 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  60 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "BENCH_END_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  64 */           return item.sprite(rx, ry) instanceof RoomSprite1x1;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  69 */           snick.renderRandom(r, s, it, it.ran(), degrade);
/*     */         }
/*     */       };
/*     */     
/*  73 */     final RoomSprite1x1 sBenchMid = new RoomSprite1x1(sp, "BENCH_CENTRE_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  76 */           return item.sprite(rx, ry) instanceof RoomSprite1x1;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  81 */           snick.renderRandom(r, s, it, it.ran(), degrade);
/*     */         }
/*     */       };
/*  84 */     RoomSprite1x1 roomSprite1x13 = new RoomSprite1x1(sp, "MANTEL_A_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  87 */           return (item.sprite(rx, ry) == sBenchMid);
/*     */         }
/*     */       };
/*     */     
/*  91 */     RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(sp, "MANTEL_B_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  94 */           return (item.sprite(rx, ry) == sBenchMid);
/*     */         }
/*     */       };
/*  97 */     RoomSprite1x1 roomSprite1x15 = new RoomSprite1x1(sp, "BEDPOST_A_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 100 */           return item.sprite(rx, ry) instanceof RoomSpriteXxX;
/*     */         }
/*     */       };
/* 103 */     RoomSprite1x1 roomSprite1x16 = new RoomSprite1x1(sp, "BEDPOST_B_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 106 */           return item.sprite(rx, ry) instanceof RoomSpriteXxX;
/*     */         }
/*     */       };
/*     */     
/* 110 */     RoomSpriteCombo roomSpriteCombo = new RoomSpriteCombo(sp, "CARPET_COMBO")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 113 */           return (item.sprite(rx, ry) == this);
/*     */         }
/*     */       };
/* 116 */     RoomSpriteXxX roomSpriteXxX2 = new RoomSpriteXxX(2)
/*     */       {
/*     */         public Sheets sheet(RenderData.RenderIterator it)
/*     */         {
/* 120 */           ChamberInstance ins = (ChamberInstance)blue.get(it.tx(), it.ty());
/* 121 */           if (ins != null && ins.occupant() != null)
/* 122 */             return (ins.occupant().race().home().clas(ins.occupant().indu())).statue.get(ins); 
/* 123 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 128 */     RoomSprite.Dummy dummy = new RoomSprite.Dummy()
/*     */       {
/*     */       
/*     */       };
/*     */ 
/*     */     
/* 134 */     this.bb = new FurnisherItemTile(
/* 135 */         this, 
/* 136 */         (RoomSprite)roomSpriteXxX1, 
/* 137 */         AVAILABILITY.PENALTY4, 
/* 138 */         false);
/* 139 */     FurnisherItemTile bc = new FurnisherItemTile(
/* 140 */         this, 
/* 141 */         (RoomSprite)roomSpriteXxX1, 
/* 142 */         AVAILABILITY.PENALTY4, 
/* 143 */         false);
/* 144 */     FurnisherItemTile b1 = new FurnisherItemTile(
/* 145 */         this, 
/* 146 */         (RoomSprite)roomSprite1x15, 
/* 147 */         AVAILABILITY.ROOM_SOLID, 
/* 148 */         false);
/* 149 */     FurnisherItemTile b2 = new FurnisherItemTile(
/* 150 */         this, 
/* 151 */         (RoomSprite)roomSprite1x16, 
/* 152 */         AVAILABILITY.ROOM_SOLID, 
/* 153 */         false);
/* 154 */     FurnisherItemTile x1 = new FurnisherItemTile(
/* 155 */         this, 
/* 156 */         (RoomSprite)roomSprite1x11, 
/* 157 */         AVAILABILITY.ROOM_SOLID, 
/* 158 */         true);
/* 159 */     FurnisherItemTile xx = new FurnisherItemTile(
/* 160 */         this, 
/* 161 */         (RoomSprite)roomSprite1x12, 
/* 162 */         AVAILABILITY.ROOM_SOLID, 
/* 163 */         true);
/* 164 */     FurnisherItemTile m1 = new FurnisherItemTile(
/* 165 */         this, 
/* 166 */         (RoomSprite)roomSprite1x13, 
/* 167 */         AVAILABILITY.ROOM_SOLID, 
/* 168 */         true);
/* 169 */     FurnisherItemTile m2 = new FurnisherItemTile(
/* 170 */         this, 
/* 171 */         (RoomSprite)roomSprite1x14, 
/* 172 */         AVAILABILITY.ROOM_SOLID, 
/* 173 */         true);
/* 174 */     FurnisherItemTile cc = new FurnisherItemTile(
/* 175 */         this, 
/* 176 */         (RoomSprite)roomSpriteCombo, 
/* 177 */         AVAILABILITY.ROOM, 
/* 178 */         false);
/* 179 */     FurnisherItemTile ss = new FurnisherItemTile(
/* 180 */         this, 
/* 181 */         (RoomSprite)roomSpriteXxX2, 
/* 182 */         AVAILABILITY.ROOM_SOLID, 
/* 183 */         false);
/*     */     
/* 185 */     FurnisherItemTile ee = new FurnisherItemTile(
/* 186 */         this, 
/* 187 */         true, 
/* 188 */         (RoomSprite)dummy, 
/* 189 */         AVAILABILITY.ROOM, 
/* 190 */         false);
/* 191 */     ee.noWalls = true;
/*     */     
/* 193 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 194 */         this, 
/* 195 */         (RoomSprite)dummy, 
/* 196 */         AVAILABILITY.ROOM, 
/* 197 */         false);
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
/* 209 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 215 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 220 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 226 */     return (Room)new ChamberInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 231 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isHeavy() {
/* 236 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\chamber\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */