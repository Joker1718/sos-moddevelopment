/*     */ package game.battle;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.BitmapSprite;
/*     */ import java.io.IOException;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ 
/*     */ public class DivisionBanners
/*     */   implements SAVABLE
/*     */ {
/*     */   private final DivisionBanner[] all;
/*     */   
/*     */   DivisionBanners() {
/*  24 */     Bitmap2D[] data = BitmapSprite.read(PATHS.SPRITE_UI().get("DivisionSymbols"));
/*  25 */     this.all = new DivisionBanner[data.length];
/*  26 */     COLOR[] cols = COLOR.generateUnique(40, data.length, true);
/*  27 */     for (int i = 0; i < data.length; i++) {
/*  28 */       DivisionBanner d = new DivisionBanner(new BitmapSprite());
/*  29 */       d.sprite.paint(data[i]);
/*  30 */       d.col.set(cols[i]);
/*  31 */       this.all[i] = d;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public DivisionBanner get(int index) {
/*  37 */     index %= this.all.length;
/*  38 */     if (index < 0)
/*  39 */       index += this.all.length; 
/*  40 */     return this.all[index];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  47 */     file.i(this.all.length); byte b; int i; DivisionBanner[] arrayOfDivisionBanner;
/*  48 */     for (i = (arrayOfDivisionBanner = this.all).length, b = 0; b < i; ) { DivisionBanner d = arrayOfDivisionBanner[b];
/*  49 */       d.sprite.save(file);
/*  50 */       d.col.save(file);
/*  51 */       d.bg.save(file);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  57 */     int am = file.i();
/*  58 */     for (int i = 0; i < am; i++) {
/*  59 */       (get(i)).sprite.load(file);
/*  60 */       (get(i)).col.load(file);
/*  61 */       (get(i)).bg.load(file);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {}
/*     */ 
/*     */   
/*     */   public class DivisionBanner
/*     */     implements SPRITE
/*     */   {
/*     */     public final BitmapSprite sprite;
/*     */     
/*  75 */     public final ColorImp col = new ColorImp();
/*  76 */     public final ColorImp bg = new ColorImp(20, 20, 20);
/*  77 */     private final int m = 2;
/*     */     
/*     */     public DivisionBanner(BitmapSprite sprite) {
/*  80 */       this.sprite = sprite;
/*     */     }
/*     */ 
/*     */     
/*     */     public int width() {
/*  85 */       return 28;
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/*  90 */       return 28;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 103 */       int s = (X2 - X1) / width();
/* 104 */       if (s < 1) {
/* 105 */         s = 1;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 113 */       renderSymbol(r, X1 + 2, Y1 + 2, s);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderSymbol(SPRITE_RENDERER r, int X1, int Y1, int scale) {
/* 122 */       for (int y = -1; y <= 26; y++) {
/* 123 */         for (int x = -1; x <= 26; x++) {
/* 124 */           int dx = (x - 1) / 2;
/* 125 */           int dy = (y - 1) / 2;
/*     */           
/* 127 */           if (this.sprite.is(dx, dy)) {
/* 128 */             ColorImp colorImp = this.col;
/* 129 */             for (DIR d : DIR.ALL) {
/* 130 */               int ddx = (x - 1 + d.x()) / 2;
/* 131 */               int ddy = (y - 1 + d.y()) / 2;
/* 132 */               if (!this.sprite.is(ddx, ddy)) {
/* 133 */                 colorImp = ColorImp.TMP.set((COLOR)colorImp).shadeSelf(0.6D);
/*     */                 break;
/*     */               } 
/*     */             } 
/* 137 */             colorImp.render(r, X1 + x * scale, X1 + x * scale + scale, Y1 + y * scale, Y1 + y * scale + scale);
/*     */           } else {
/* 139 */             for (DIR d : DIR.ALL) {
/* 140 */               int ddx = (x - 1 + d.x()) / 2;
/* 141 */               int ddy = (y - 1 + d.y()) / 2;
/* 142 */               if (this.sprite.is(ddx, ddy)) {
/* 143 */                 this.bg.render(r, X1 + x * scale, X1 + x * scale + scale, Y1 + y * scale, Y1 + y * scale + scale);
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 160 */     return this.all.length;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\DivisionBanners.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */