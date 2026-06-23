/*     */ package settlement.room.sprite;
/*     */ 
/*     */ import init.sprite.game.SheetType;
/*     */ import java.io.IOException;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ public class RoomSprite1xN
/*     */   extends RoomSprite1x1
/*     */ {
/*     */   private final boolean master;
/*     */   
/*     */   public RoomSprite1xN(Json json, String key, boolean master) throws IOException {
/*  18 */     super(json, key);
/*  19 */     this.master = master;
/*     */   }
/*     */   
/*     */   public RoomSprite1xN(RoomSprite other, boolean master) throws IOException {
/*  23 */     super(other);
/*  24 */     this.master = master;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  31 */     it.ranOffset(offX(data), offY(data));
/*  32 */     return super.render(r, s, getRot(data), it, degrade, isCandle);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/*  40 */     DIR d = rot(data);
/*  41 */     int m = d.mask();
/*  42 */     if ((data & 0x4) != 0) {
/*  43 */       m |= d.perpendicular().mask();
/*     */     }
/*  45 */     SheetType.sCombo.renderOverlay(x, y, r, (item.get(rx, ry)).availability, m, 0, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  50 */     int m = Math.max(item.width(), item.height());
/*  51 */     int res = -1;
/*     */     int dist;
/*  53 */     for (dist = 1; dist < m; dist++) {
/*  54 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  55 */         DIR d = (DIR)DIR.ORTHO.get(di);
/*     */         
/*  57 */         if (isMaster(rx + d.x() * dist, ry + d.y() * dist, item)) {
/*  58 */           if (res != -1) {
/*  59 */             res |= 0x4;
/*  60 */             return (byte)res;
/*     */           } 
/*  62 */           res = di | dist << 3;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  67 */     if (res != -1) {
/*  68 */       return (byte)res;
/*     */     }
/*  70 */     for (dist = 1; dist < m; dist++) {
/*  71 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  72 */         DIR d = (DIR)DIR.ORTHO.get(di);
/*     */         
/*  74 */         if (joins(rx + d.x() * dist, ry + d.y() * dist, item, !this.master)) {
/*  75 */           if (res != -1) {
/*  76 */             res |= 0x4;
/*  77 */             return (byte)res;
/*     */           } 
/*  79 */           res = di | dist << 3;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  85 */     if (res != -1)
/*  86 */       return (byte)res; 
/*  87 */     return (byte)item.rotation;
/*     */   }
/*     */   
/*     */   protected boolean isMaster(int rx, int ry, FurnisherItem item) {
/*  91 */     RoomSprite s = item.sprite(rx, ry);
/*  92 */     if (s == null)
/*  93 */       return false; 
/*  94 */     if (s instanceof RoomSprite1xN) {
/*  95 */       return this.master ^ ((RoomSprite1xN)s).master;
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   protected final boolean joins(int rx, int ry, FurnisherItem item, boolean master) {
/* 101 */     RoomSprite s = item.sprite(rx, ry);
/* 102 */     if (s == null)
/* 103 */       return false; 
/* 104 */     if (s instanceof RoomSprite1xN) {
/* 105 */       return master ^ ((RoomSprite1xN)s).master;
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 112 */     RoomSprite s = item.sprite(rx, ry);
/* 113 */     if (s == null)
/* 114 */       return false; 
/* 115 */     if (s instanceof RoomSprite1xN) {
/* 116 */       return this.master ^ ((RoomSprite1xN)s).master;
/*     */     }
/* 118 */     return false;
/*     */   }
/*     */   
/*     */   public int offX(int data) {
/* 122 */     if (this.master)
/* 123 */       return 0; 
/* 124 */     DIR d = rot(data);
/* 125 */     return d.x() * (data >> 3 & 0x1F);
/*     */   }
/*     */   
/*     */   public int offY(int data) {
/* 129 */     if (this.master)
/* 130 */       return 0; 
/* 131 */     DIR d = rot(data);
/* 132 */     return d.y() * (data >> 3 & 0x1F);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\sprite\RoomSprite1xN.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */