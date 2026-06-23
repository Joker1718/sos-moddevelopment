/*     */ package settlement.room.infra.importt;
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
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_IMPORT blue;
/*     */   final FurnisherStat crates;
/*     */   private final FurnisherItemTile cr;
/*     */   private final Floors.Floor floor2;
/*     */   
/*     */   boolean isCrate(int tx, int ty) {
/*  43 */     return ((SETT.ROOMS()).fData.tIndex.get(tx, ty) == this.cr.index());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Constructor(final ROOM_IMPORT blue, RoomInitData init) throws IOException {
/*  51 */     super(init, 1, 1, 152, 100);
/*  52 */     this.blue = blue;
/*  53 */     this.floor2 = (Floors.Floor)(SETT.FLOOR()).map.read("FLOOR2", init.data());
/*  54 */     this.crates = new FurnisherStat(this, 1.0D)
/*     */       {
/*     */         public double get(AREA area, double fromItems)
/*     */         {
/*  58 */           return fromItems;
/*     */         }
/*     */ 
/*     */         
/*     */         public GText format(GText t, double value) {
/*  63 */           return GFORMAT.i(t, (int)value);
/*     */         }
/*     */       };
/*     */     
/*  67 */     Json sp = init.data().json("SPRITES");
/*     */     
/*  69 */     RoomSprite1x1 roomSprite1x1 = new RoomSprite1x1(sp, "CRATE_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  73 */           return (item.rotation == d.orthoID());
/*     */         }
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  77 */           super.render(r, s, data, it, degrade, isCandle);
/*  78 */           ImportInstance ins = (ImportInstance)(SETT.ROOMS()).IMPORT.getter.get(it.tile());
/*  79 */           if (ins != null && 
/*  80 */             ins.resource() != null) {
/*  81 */             int a = blue.crate.amount(it.tx(), it.ty(), ins, ins.sdata);
/*  82 */             ins.resource().renderLaying(r, it.x(), it.y(), it.ran(), a);
/*     */           } 
/*     */           
/*  85 */           return true;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  90 */     RoomSprite.Imp marker = new RoomSprite.Imp()
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/*  94 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  99 */           ImportInstance ins = (ImportInstance)(SETT.ROOMS()).IMPORT.getter.get(it.tile());
/* 100 */           if (ins == null)
/*     */             return; 
/* 102 */           Icon icon = (ins.resource() == null) ? (SPRITES.icons()).m.cancel : ins.resource().icon();
/* 103 */           OPACITY.O99.bind();
/* 104 */           icon.render(r, it.x(), it.x() + 64, it.y(), it.y() + 64);
/* 105 */           OPACITY.unbind();
/*     */           
/* 107 */           super.renderBelow(r, s, data, it, degrade);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 113 */           return 0;
/*     */         }
/*     */       };
/*     */     
/* 117 */     this.cr = new FurnisherItemTile(
/* 118 */         this, 
/* 119 */         true, 
/* 120 */         (RoomSprite)roomSprite1x1, 
/* 121 */         AVAILABILITY.ROOM_SOLID, 
/* 122 */         false);
/*     */     
/* 124 */     FurnisherItemTile ca = new FurnisherItemTile(
/* 125 */         this, 
/* 126 */         false, 
/* 127 */         (RoomSprite)roomSprite1x1, 
/* 128 */         AVAILABILITY.ROOM_SOLID, 
/* 129 */         true);
/*     */     
/* 131 */     FurnisherItemTile ee = new FurnisherItemTile(
/* 132 */         this, 
/* 133 */         (RoomSprite)new SpriteThingy(sp, "POST_1X1"), 
/* 134 */         AVAILABILITY.ROOM, 
/* 135 */         false);
/*     */     
/* 137 */     FurnisherItemTile cc = new FurnisherItemTile(
/* 138 */         this, 
/* 139 */         (RoomSprite)new SpriteThingy(sp, "FENCE_1X1"), 
/* 140 */         AVAILABILITY.ROOM, 
/* 141 */         false);
/*     */     
/* 143 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 144 */         this, 
/* 145 */         null, 
/* 146 */         AVAILABILITY.ROOM, 
/* 147 */         false);
/*     */     
/* 149 */     FurnisherItemTile mm = new FurnisherItemTile(
/* 150 */         this, 
/* 151 */         (RoomSprite)marker, 
/* 152 */         AVAILABILITY.ROOM, 
/* 153 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 220 */     flush(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 226 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 231 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 237 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 242 */     for (DIR d : DIR.ALL) {
/* 243 */       if (!area.is(tx, ty, d)) {
/* 244 */         super.putFloor(tx, ty, upgrade, area);
/*     */         return;
/*     */       } 
/*     */     } 
/* 248 */     this.floor2.placeFixed(tx, ty);
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
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 273 */     return (Room)new ImportInstance(this.blue, area, init);
/*     */   }
/*     */   
/*     */   private class SpriteThingy
/*     */     extends RoomSprite1x1
/*     */   {
/*     */     public SpriteThingy(Json js, String key) throws IOException {
/* 280 */       super(js, key);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 288 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 293 */       super.render(r, s, data, it, degrade, false);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 299 */       return item.sprite(rx, ry) instanceof SpriteThingy;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\importt\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */