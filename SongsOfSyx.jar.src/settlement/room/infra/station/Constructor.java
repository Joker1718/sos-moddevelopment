/*     */ package settlement.room.infra.station;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RESOURCE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_STATION blue;
/*     */   private final Floors.Floor floor2;
/*     */   public static final double RAND = 0.00392156862745098D;
/*     */   public static final int BIT_WORK = 1;
/*     */   public static final int BIT_CRATE = 2;
/*     */   private static final int BIT_FLOOR = 4;
/*     */   public static final int BIT_DEST = 8;
/*     */   
/*     */   protected Constructor(final ROOM_STATION blue, RoomInitData init) throws IOException {
/*  43 */     super(init, 1, 0);
/*     */ 
/*     */     
/*  46 */     this.blue = blue;
/*  47 */     this.floor2 = (Floors.Floor)(SETT.FLOOR()).map.read("FLOOR2", init.data());
/*     */ 
/*     */     
/*  50 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  52 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1(sp, "WORK_1X1", sp)
/*     */       {
/*     */         final RoomSprite top;
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  58 */           StationInstance ins = (StationInstance)blue.get(it.tx(), it.ty());
/*  59 */           if (ins != null && 
/*  60 */             ins.prepD() + (GUTIL.ran2().get(it.tile()) & 0xFF) * 0.00392156862745098D >= 1.0D) {
/*     */             return;
/*     */           }
/*  63 */           this.top.render(r, s, getData2(it), it, degrade, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  68 */           return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  73 */     RoomSprite1x1 roomSprite1x12 = new RoomSprite1x1(sp, "ANIMAL_TOP_1X1", sp)
/*     */       {
/*     */         final RoomSprite water;
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  79 */           StationInstance ins = (StationInstance)blue.get(it.tx(), it.ty());
/*  80 */           if (ins != null && 
/*  81 */             ins.prepD() + (GUTIL.ran2().get(it.tile()) & 0xFF) * 0.00392156862745098D >= 1.0D) {
/*  82 */             this.water.render(r, s, data, it, degrade, false);
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  89 */     final RoomSprite1x1 sAnimal = new RoomSprite1x1(sp, "ROOF_MID_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  92 */           return (item.sprite(rx, ry) == this);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  98 */           StationInstance ins = (StationInstance)blue.get(it.tx(), it.ty());
/*  99 */           if (ins != null && 
/* 100 */             ins.prepD() + (GUTIL.ran2().get(it.tile()) & 0xFF) * 0.00392156862745098D >= 1.0D) {
/* 101 */             DIR d = (DIR)DIR.ORTHO.get(((FurnisherItem)(SETT.ROOMS()).fData.item.get(it.tile())).rotation);
/*     */             
/* 103 */             double mov = (GAME.intervals().get05() + it.ran() & 0xFF);
/* 104 */             mov /= 255.0D;
/* 105 */             SETT.ANIMALS().renderCaravan(r, s, mov, it.x() + 32 + d.x() * 32, it.y() + 32 + d.y() * 32, null, 0, false, d.id(), it.ran());
/*     */           } 
/*     */ 
/*     */           
/* 109 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 114 */           s.setSoft();
/* 115 */           super.render(r, s, data, it, degrade, false);
/* 116 */           s.setPrev();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 121 */     RoomSprite1x1 roomSprite1x14 = new RoomSprite1x1(sp, "ROOF_EDGE_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 124 */           return (item.sprite(rx, ry) == sAnimal);
/*     */         }
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 128 */           s.setSoft();
/* 129 */           super.render(r, s, data, it, degrade, false);
/* 130 */           s.setPrev();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 136 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 141 */     RoomSprite1x1 roomSprite1x15 = new RoomSprite1x1(sp, "CRATE_BOTTOM_1X1", sp)
/*     */       {
/*     */         final RoomSprite top;
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 147 */           this.top.render(r, s, data, it, degrade, this.rotates);
/* 148 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 154 */           super.render(r, s, data, it, degrade, false);
/*     */           
/* 156 */           Crate c = blue.crate;
/*     */           
/* 158 */           if (c.get(it.tx(), it.ty()) != null && c.resource() != null) {
/* 159 */             double am = c.stored.get();
/* 160 */             RESOURCE res = c.resource();
/* 161 */             if (am > 0.0D && res != null) {
/* 162 */               res.renderLayingRel(r, it.x(), it.y(), it.ran(), am / 400.0D);
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 168 */     RoomSprite1x1 roomSprite1x16 = new RoomSprite1x1(sp, "TORCH_1X1");
/*     */     
/* 170 */     FurnisherItemTile pp = new FurnisherItemTile(
/* 171 */         this, 
/* 172 */         false, 
/* 173 */         (RoomSprite)roomSprite1x16, 
/* 174 */         AVAILABILITY.ROOM_SOLID, 
/* 175 */         true);
/* 176 */     pp.setData(8);
/*     */     
/* 178 */     FurnisherItemTile dd = new FurnisherItemTile(
/* 179 */         this, 
/* 180 */         false, 
/* 181 */         (RoomSprite)roomSprite1x16, 
/* 182 */         AVAILABILITY.ROOM_SOLID, 
/* 183 */         true);
/* 184 */     dd.setData(8);
/*     */     
/* 186 */     FurnisherItemTile st = new FurnisherItemTile(
/* 187 */         this, 
/* 188 */         false, 
/* 189 */         (RoomSprite)roomSprite1x15, 
/* 190 */         AVAILABILITY.ROOM_SOLID, 
/* 191 */         false);
/* 192 */     st.setData(3);
/*     */     
/* 194 */     FurnisherItemTile ww = new FurnisherItemTile(
/* 195 */         this, 
/* 196 */         false, 
/* 197 */         (RoomSprite)roomSprite1x11, 
/* 198 */         AVAILABILITY.ROOM_SOLID, 
/* 199 */         false);
/* 200 */     ww.setData(1);
/*     */     
/* 202 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 203 */         this, 
/* 204 */         false, 
/* 205 */         (RoomSprite)new RoomSprite.Dummy(), 
/* 206 */         AVAILABILITY.ROOM, 
/* 207 */         false);
/*     */     
/* 209 */     FurnisherItemTile an = new FurnisherItemTile(
/* 210 */         this, 
/* 211 */         false, 
/* 212 */         (RoomSprite)roomSprite1x13, 
/* 213 */         AVAILABILITY.ROOM_SOLID, 
/* 214 */         false);
/* 215 */     an.setData(4);
/*     */     
/* 217 */     FurnisherItemTile ae = new FurnisherItemTile(
/* 218 */         this, 
/* 219 */         false, 
/* 220 */         (RoomSprite)roomSprite1x14, 
/* 221 */         AVAILABILITY.ROOM_SOLID, 
/* 222 */         false);
/* 223 */     ae.setData(4);
/*     */     
/* 225 */     FurnisherItemTile af = new FurnisherItemTile(
/* 226 */         this, 
/* 227 */         false, 
/* 228 */         (RoomSprite)roomSprite1x12, 
/* 229 */         AVAILABILITY.ROOM_SOLID, 
/* 230 */         false);
/* 231 */     af.setData(5);
/*     */     
/* 233 */     FurnisherItemTile in = (new FurnisherItemTile(
/* 234 */         this, 
/* 235 */         false, 
/* 236 */         (RoomSprite)new RoomSprite.Dummy(), 
/* 237 */         AVAILABILITY.ROOM, 
/* 238 */         false)).setData(1);
/* 239 */     in.setData(4);
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
/* 287 */     flush(3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 293 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 298 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 304 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 309 */     if ((SETT.ROOMS()).fData.tile.get(tx, ty) != null && (((FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty)).data() & 0x4) != 0) {
/* 310 */       this.floor2.placeFixed(tx, ty);
/*     */     } else {
/* 312 */       super.putFloor(tx, ty, upgrade, area);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 318 */     return (Room)new StationInstance(this.blue, area, init);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\station\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */