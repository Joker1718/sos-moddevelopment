/*     */ package launcher;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ final class ScreenLang extends GuiSection {
/*  18 */   private final PATH plang = PATHS.PATHS_BASE.langs(); private CharSequence hov;
/*     */   private final Launcher l;
/*     */   
/*     */   public ScreenLang(final Launcher l, boolean exit) {
/*  22 */     this.l = l;
/*  23 */     int i = 0;
/*  24 */     int cols = 10;
/*  25 */     int width = 64;
/*  26 */     int height = 64;
/*     */     
/*  28 */     addGridD((RENDEROBJ)new Butt(null, i), i++, cols, width, height, DIR.C); byte b; int j; String[] arrayOfString;
/*  29 */     for (j = (arrayOfString = this.plang.folders()).length, b = 0; b < j; ) { String s = arrayOfString[b];
/*  30 */       addGridD((RENDEROBJ)new Butt(s, i), i++, cols, width, height, DIR.C);
/*     */       b++; }
/*     */     
/*  33 */     body().moveC(448.0D, 224.0D);
/*     */     
/*  35 */     D.gInit(this);
/*     */     
/*  37 */     if (exit) {
/*  38 */       GUI.BText bText = new GUI.BText(l.res, D.g("Back"))
/*     */         {
/*     */           protected void clickA() {
/*  41 */             l.setMain();
/*     */           }
/*     */         };
/*  44 */       bText.body().moveY1(16.0D).moveX2(880.0D);
/*  45 */       add((RENDEROBJ)bText);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  53 */     OPACITY.O75.bind();
/*  54 */     COLOR.BLACK.render(r, 0, 896, 0, 448);
/*  55 */     OPACITY.unbind();
/*  56 */     super.render(r, ds);
/*  57 */     if (this.hov != null) {
/*  58 */       this.l.res.font.renderC(r, 448, body().y2() + 24, this.hov);
/*  59 */       this.hov = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public CLICKABLE butt() {
/*  64 */     int si = 0;
/*  65 */     if (!this.l.s.lang.get().equals("")) {
/*  66 */       byte b; int i; String[] arrayOfString; for (i = (arrayOfString = this.plang.folders()).length, b = 0; b < i; ) { String s = arrayOfString[b];
/*  67 */         si++;
/*  68 */         if (this.l.s.lang.get().equals(s)) {
/*     */           break;
/*     */         }
/*     */         b++; }
/*     */     
/*     */     } 
/*  74 */     return (CLICKABLE)new GUI.Button(this.l.res.langs[si].scaled(2.0D))
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  78 */           ScreenLang.this.l.setLang();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private class Butt
/*     */     extends GUI.Button
/*     */   {
/*     */     private final String code;
/*     */     private final String name;
/*     */     
/*     */     Butt(String folder, int iconI) {
/*  90 */       super(ScreenLang.this.l.res.langs[iconI].scaled(2.0D));
/*     */       
/*  92 */       if (folder == null) {
/*  93 */         this.code = "";
/*  94 */         this.name = "English";
/*     */       } else {
/*  96 */         this.code = folder;
/*  97 */         Json j = new Json(ScreenLang.this.plang.getFolder(folder).gets("_Info"));
/*  98 */         this.name = j.text("NAME") + " " + j.text("NAME") + "%";
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 104 */       if (super.hover(mCoo)) {
/* 105 */         ScreenLang.this.hov = this.name;
/* 106 */         return true;
/*     */       } 
/* 108 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 113 */       if (ScreenLang.this.l.s.lang.get().equals(this.code)) {
/* 114 */         ScreenLang.this.l.setMain();
/*     */       } else {
/* 116 */         ScreenLang.this.l.s.lang.set(this.code);
/* 117 */         ScreenLang.this.l.s.save();
/* 118 */         ScreenLang.this.l.reboot();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenLang.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */