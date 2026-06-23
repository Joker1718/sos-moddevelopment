/*     */ package settlement.room.infra.export;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
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
/*     */ import settlement.room.sprite.RoomSpriteImp;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_EXPORT blue;
/*     */   final FurnisherStat crates;
/*     */   private final Floors.Floor floor2;
/*     */   private static final int ICRATE = 1;
/*     */   private static final int ICANDLE = 2;
/*     */   
/*     */   boolean isCrate(int tx, int ty) {
/*  44 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Constructor(ROOM_EXPORT blue, RoomInitData init) throws IOException {
/*  49 */     super(init, 1, 1, 88, 44);
/*  50 */     this.blue = blue;
/*  51 */     this.floor2 = (Floors.Floor)(SETT.FLOOR()).map.read("FLOOR2", init.data());
/*  52 */     this.crates = new FurnisherStat(this, 1.0D)
/*     */       {
/*     */         public double get(AREA area, double fromItems)
/*     */         {
/*  56 */           return fromItems;
/*     */         }
/*     */ 
/*     */         
/*     */         public GText format(GText t, double value) {
/*  61 */           return GFORMAT.i(t, (int)value);
/*     */         }
/*     */       };
/*     */     
/*  65 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  67 */     RoomSprite1x1 sCrate = new RoomSprite1x1(sp, "CRATE_1X1")
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  70 */           super.render(r, s, data, it, degrade, isCandle);
/*  71 */           Constructor.this.renderCrate(r, s, data, it, degrade, isCandle);
/*  72 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  77 */     final RoomSpriteCombo sRoof = new RoomSpriteCombo(sp, "ROOF_COMBO")
/*     */       {
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  82 */           s.setSoft();
/*  83 */           DIR rot = ((DIR)DIR.ORTHO.get(((FurnisherItem)(SETT.ROOMS()).fData.item.get(it.tile())).rotation)).next(-1);
/*  84 */           it.setOff(rot.x() * 32, rot.y() * 32);
/*  85 */           super.render(r, s, data, it, degrade, isCandle);
/*  86 */           s.setHard();
/*  87 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  92 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 1);
/*     */         }
/*     */       };
/*     */     
/*  96 */     RoomSpriteImp roomSpriteImp = (new RoomSprite1x1(sp, "CRATE_1X1")
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 102 */           super.render(r, s, data, it, degrade, isCandle);
/* 103 */           Constructor.this.renderCrate(r, s, data, it, degrade, isCandle);
/* 104 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 109 */           return sRoof.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 114 */           sRoof.render(r, s, getData2(it), it, degrade, this.rotates);
/*     */         }
/* 117 */       }).sData(1);
/*     */ 
/*     */ 
/*     */     
/* 121 */     RoomSprite1x1 roomSprite1x11 = new RoomSprite1x1((RoomSprite)sCrate)
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 125 */           super.render(r, s, data, it, degrade, isCandle);
/* 126 */           Constructor.this.renderCrate(r, s, data, it, degrade, isCandle);
/* 127 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 131 */     FurnisherItemTile cc = (new FurnisherItemTile(
/* 132 */         this, 
/* 133 */         true, 
/* 134 */         (RoomSprite)roomSprite1x11, 
/* 135 */         AVAILABILITY.ROOM_SOLID, 
/* 136 */         false)).setData(1);
/*     */     
/* 138 */     FurnisherItemTile ca = (new FurnisherItemTile(
/* 139 */         this, 
/* 140 */         false, 
/* 141 */         (RoomSprite)roomSprite1x11, 
/* 142 */         AVAILABILITY.ROOM_SOLID, 
/* 143 */         true)).setData(2);
/*     */     
/* 145 */     FurnisherItemTile cr = (new FurnisherItemTile(
/* 146 */         this, 
/* 147 */         true, 
/* 148 */         (RoomSprite)roomSpriteImp, 
/* 149 */         AVAILABILITY.ROOM_SOLID, 
/* 150 */         false)).setData(1);
/*     */     
/* 152 */     FurnisherItemTile rr = new FurnisherItemTile(
/* 153 */         this, 
/* 154 */         false, 
/* 155 */         (RoomSprite)roomSpriteImp, 
/* 156 */         AVAILABILITY.ROOM_SOLID, 
/* 157 */         false);
/*     */     
/* 159 */     FurnisherItemTile rc = (new FurnisherItemTile(
/* 160 */         this, 
/* 161 */         false, 
/* 162 */         (RoomSprite)roomSpriteImp, 
/* 163 */         AVAILABILITY.ROOM_SOLID, 
/* 164 */         true)).setData(2);
/*     */     
/* 166 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 167 */         this, 
/* 168 */         null, 
/* 169 */         AVAILABILITY.ROOM, 
/* 170 */         false);
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
/* 277 */     flush(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 283 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 288 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 294 */     return (RoomBlueprintImp)this.blue;
/*     */   }
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
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 317 */     for (DIR d : DIR.ALL) {
/* 318 */       if (!area.is(tx, ty, d)) {
/* 319 */         super.putFloor(tx, ty, upgrade, area);
/*     */         return;
/*     */       } 
/*     */     } 
/* 323 */     this.floor2.placeFixed(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 328 */     return (Room)new ExportInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderCrate(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 333 */     if (blue().is(it.tile())) {
/* 334 */       ExportInstance ins = (ExportInstance)this.blue.getter.get(it.tile());
/* 335 */       if ((SETT.ROOMS()).fData.tileData.get(it.tile()) == 2) {
/* 336 */         Icon icon = (ins.resource() == null) ? (SPRITES.icons()).m.cancel : ins.resource().icon();
/* 337 */         OPACITY.O99.bind();
/* 338 */         icon.render(r, it.x(), it.x() + 64, it.y(), it.y() + 64);
/* 339 */         OPACITY.unbind();
/* 340 */       } else if ((SETT.ROOMS()).fData.tileData.get(it.tile()) == 1) {
/* 341 */         int a = this.blue.crate(it.tx(), it.ty()).amount();
/*     */         
/* 343 */         if (a > 0 && ins.resource() != null)
/* 344 */           ((ExportInstance)this.blue.getter.get(it.tile())).resource().renderLaying(r, it.x(), it.y(), it.ran(), a); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\export\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */