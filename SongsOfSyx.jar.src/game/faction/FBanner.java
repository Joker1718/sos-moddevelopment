/*     */ package game.faction;
/*     */ 
/*     */ import init.sprite.BitmapSprite;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.colors.GCOLOR;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ public class FBanner
/*     */   extends FactionResource
/*     */ {
/*  23 */   private static CharSequence ¤¤name = "¤Banner";
/*     */   
/*     */   static {
/*  26 */     D.ts(FBanner.class);
/*     */   }
/*     */   
/*  29 */   public final BitmapSprite sprite = new BitmapSprite();
/*     */ 
/*     */   
/*  32 */   private byte bannerI = (byte)RND.rInt((SPRITES.icons()).l.banners.length);
/*  33 */   private final ColorImp background = new ColorImp(RND.rInt(87), RND.rInt(87), RND.rInt(87));
/*  34 */   private final ColorImp foreground = new ColorImp(40 + RND.rInt(87), 40 + RND.rInt(87), 40 + RND.rInt(87));
/*  35 */   private final ColorImp border = this.foreground.shade(0.25D);
/*  36 */   private final ColorImp pole = new ColorImp(35 + RND.rInt0(5), 35 + RND.rInt0(5), 35 + RND.rInt(5));
/*  37 */   private static ColorImp tmp = new ColorImp();
/*     */   
/*     */   public final SPRITE MEDIUM;
/*     */   public final SPRITE BIG;
/*     */   public final SPRITE HUGE;
/*     */   
/*     */   public ColorImp colorBG() {
/*  44 */     return this.background;
/*     */   }
/*     */   
/*     */   public ColorImp colorBGBright() {
/*  48 */     tmp.set((COLOR)this.background).setMinBrightnessSelf(0.75D);
/*  49 */     return tmp;
/*     */   }
/*     */   
/*     */   public ColorImp colorFG() {
/*  53 */     return this.foreground;
/*     */   }
/*     */   
/*     */   public ColorImp colorBorder() {
/*  57 */     return this.border;
/*     */   }
/*     */   
/*     */   public ColorImp colorPole() {
/*  61 */     return this.pole;
/*     */   }
/*     */   
/*     */   public int bannerType() {
/*  65 */     return this.bannerI;
/*     */   }
/*     */   
/*     */   public void bannerTypeSet(int i) {
/*  69 */     i &= 0xFFFF;
/*  70 */     this.bannerI = (byte)(i % (SPRITES.icons()).l.banners.length);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  75 */     this.sprite.save(file);
/*  76 */     file.b(this.bannerI);
/*  77 */     this.background.save(file);
/*  78 */     this.foreground.save(file);
/*  79 */     this.border.save(file);
/*  80 */     this.pole.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  85 */     this.sprite.load(file);
/*  86 */     this.bannerI = file.b();
/*  87 */     this.background.load(file);
/*  88 */     this.foreground.load(file);
/*  89 */     this.border.load(file);
/*  90 */     this.pole.load(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clear() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public static CharSequence name() {
/* 100 */     return ¤¤name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void render(SPRITE_RENDERER r, Faction f, int X1, int X2, int Y1, int Y2) {
/* 106 */     if (f == null) {
/* 107 */       (UI.icons()).s.crazy.render(r, X1, X2, Y1, Y2);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 112 */     int width = X2 - X1;
/* 113 */     int height = Y2 - Y1;
/*     */     
/* 115 */     double dx = width / 12.0D;
/* 116 */     double dy = height / 12.0D;
/*     */     
/* 118 */     ColorImp colorImp = f.banner().colorBGBright();
/*     */     
/* 120 */     for (double ry = 0.0D; ry < height; ry += dy) {
/* 121 */       for (double rx = 0.0D; rx < width; rx += dx) {
/* 122 */         int px = (int)(rx / dx);
/* 123 */         int py = (int)(ry / dy);
/*     */         
/* 125 */         int x = (int)(X1 + rx);
/* 126 */         int y = (int)(Y1 + ry);
/* 127 */         if ((f.banner()).sprite.is(px, py)) {
/* 128 */           colorImp.render(r, x, (int)Math.ceil(x + dx), y, (int)Math.ceil(y + dy));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public FBanner(Faction f) {
/* 135 */     this.MEDIUM = new SPRITE()
/*     */       {
/*     */         public int width()
/*     */         {
/* 139 */           return 24;
/*     */         }
/*     */ 
/*     */         
/*     */         public int height() {
/* 144 */           return 24;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int nopeX, int Y1, int nopeY) {
/* 155 */           (SPRITES.icons()).m.circle_frame.render(r, X1, Y1);
/* 156 */           FBanner.this.background.bind();
/* 157 */           (SPRITES.icons()).m.circle_inner.render(r, X1, Y1);
/*     */           
/* 159 */           int sx = X1 + (width() - 12) / 2;
/* 160 */           int sy = Y1 + (height() - 12) / 2;
/*     */           
/* 162 */           for (int y = 0; y < 12; y++) {
/* 163 */             for (int x = 0; x < 12; x++) {
/* 164 */               if (FBanner.this.sprite.is(x, y)) {
/* 165 */                 FBanner.this.foreground.render(r, sx + x, sx + x + 1, sy + y, sy + y + 1);
/* 166 */               } else if (FBanner.this.sprite.is(x, y, DIR.N) || FBanner.this.sprite.is(x, y, DIR.E)) {
/* 167 */                 FBanner.this.border.render(r, sx + x, sx + x + 1, sy + y, sy + y + 1);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 176 */     this.BIG = new SPRITE()
/*     */       {
/*     */         public int width()
/*     */         {
/* 180 */           return 32;
/*     */         }
/*     */ 
/*     */         
/*     */         public int height() {
/* 185 */           return 32;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {
/* 190 */           (SPRITES.icons()).l.banners[FBanner.this.bannerI].renderTextured(texture, X1, X2, Y1, Y2);
/* 191 */           (SPRITES.icons()).l.bannerPole.renderTextured(texture, X1, X2, Y1, Y2);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int nopeX, int Y1, int nopeY) {
/* 197 */           FBanner.this.background.bind();
/* 198 */           (SPRITES.icons()).l.banners[FBanner.this.bannerI].render(r, X1, nopeX, Y1, nopeY);
/* 199 */           FBanner.this.pole.bind();
/* 200 */           (SPRITES.icons()).l.bannerPole.render(r, X1, nopeX, Y1, nopeY);
/*     */           
/* 202 */           FBanner.this.sprite.scaled(r, X1 + (width() - 24) / 2, Y1 + (height() - 24) / 2 + 1, 2, (COLOR)FBanner.this.foreground, (COLOR)FBanner.this.border, (COLOR)FBanner.this.border);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 208 */     this.HUGE = new SPRITE()
/*     */       {
/*     */         public int width()
/*     */         {
/* 212 */           return 64;
/*     */         }
/*     */ 
/*     */         
/*     */         public int height() {
/* 217 */           return 64;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {
/* 222 */           (SPRITES.icons()).l.banners[FBanner.this.bannerI].renderTextured(texture, X1, X2, Y1, Y2);
/* 223 */           (SPRITES.icons()).l.bannerPole.renderTextured(texture, X1, X2, Y1, Y2);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int nopeX, int Y1, int nopeY) {
/* 229 */           FBanner.this.background.bind();
/* 230 */           (SPRITES.icons()).l.banners[FBanner.this.bannerI].render(r, X1, nopeX, Y1, nopeY);
/* 231 */           FBanner.this.pole.bind();
/* 232 */           (SPRITES.icons()).l.bannerPole.render(r, X1, nopeX, Y1, nopeY);
/*     */           
/* 234 */           FBanner.this.sprite.scaled(r, X1 + (width() - 48) / 2, Y1 + (height() - 48) / 2 + 2, 4, (COLOR)FBanner.this.foreground, (COLOR)FBanner.this.border, (COLOR)FBanner.this.border);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static class rebel
/*     */   {
/* 242 */     public static final SPRITE MEDIUM = (SPRITE)new SPRITE.Imp(24)
/*     */       {
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 247 */           (SPRITES.icons()).m.circle_frame.render(r, X1, Y1);
/* 248 */           (GCOLOR.MAP()).F_REBEL.bind();
/* 249 */           (SPRITES.icons()).m.circle_inner.render(r, X1, Y1);
/* 250 */           COLOR.unbind();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 255 */     public static final SPRITE BIG = (SPRITE)new SPRITE.Imp(32)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 259 */           (GCOLOR.MAP()).F_REBEL.bind();
/* 260 */           (SPRITES.icons()).l.banners[0].render(r, X1, X2, Y1, Y2);
/* 261 */           COLOR.WHITE30.bind();
/* 262 */           (SPRITES.icons()).l.bannerPole.render(r, X1, X2, Y1, Y2);
/* 263 */           COLOR.unbind();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 268 */     public static final SPRITE HUGE = (SPRITE)new SPRITE.Imp(64)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 272 */           (GCOLOR.MAP()).F_REBEL.bind();
/* 273 */           (SPRITES.icons()).l.banners[0].render(r, X1, X2, Y1, Y2);
/* 274 */           COLOR.WHITE30.bind();
/* 275 */           (SPRITES.icons()).l.bannerPole.render(r, X1, X2, Y1, Y2);
/* 276 */           COLOR.unbind();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected void update(double ds, Faction f) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FBanner.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */