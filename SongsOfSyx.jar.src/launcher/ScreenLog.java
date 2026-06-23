/*     */ package launcher;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.util.List;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ class ScreenLog
/*     */   extends GuiSection
/*     */ {
/*     */   private final Lines lines;
/*     */   
/*     */   ScreenLog(final Launcher l) {
/*  27 */     D.gInit(this);
/*  28 */     add((RENDEROBJ)new GUI.Header(l.res, D.g("Change-Log")), 20, 16);
/*     */     
/*  30 */     CLICKABLE b = (new GUI.BText(l.res, "BACK")).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/*  33 */             l.setMain();
/*     */           }
/*     */         });
/*  36 */     b.body().moveX2(876.0D).moveCY(getLast().cY());
/*  37 */     add((RENDEROBJ)b);
/*     */     
/*  39 */     this.lines = new Lines(l.res, 448 - body().y2() - 16);
/*  40 */     this.lines.body().moveX1Y1(10.0D, (body().y2() + 8));
/*  41 */     add((RENDEROBJ)this.lines);
/*     */ 
/*     */     
/*  44 */     CLICKABLE up = (new GUI.BSprite(l.res.arrowUpDown[0])).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/*  47 */             ScreenLog.this.lines.top -= 5;
/*     */           }
/*     */         });
/*  50 */     up.body().moveY1(85.0D).moveX2(886.0D);
/*  51 */     add((RENDEROBJ)up);
/*     */     
/*  53 */     CLICKABLE down = (new GUI.BSprite(l.res.arrowUpDown[1])).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/*  56 */             ScreenLog.this.lines.top += 5;
/*     */           }
/*     */         });
/*  59 */     down.body().moveY2(388.0D).moveX2(886.0D);
/*  60 */     add((RENDEROBJ)down);
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
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  75 */     OPACITY.O75.bind();
/*  76 */     COLOR.BLACK.render(r, 0, 896, 0, 448);
/*  77 */     OPACITY.unbind();
/*     */ 
/*     */     
/*  80 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Lines
/*     */     extends RENDEROBJ.RenderImp
/*     */   {
/*  87 */     private CharSequence[] lines = lines();
/*  88 */     int top = 0;
/*  89 */     private final String sep = "-";
/*  90 */     private final COLOR[] cols = new COLOR[] {
/*  91 */         COLOR.WHITE100, 
/*  92 */         (COLOR)new ColorImp(127, 110, 100)
/*     */       };
/*     */     
/*     */     private final Font font;
/*     */     
/*     */     Lines(RES res, int height) {
/*  98 */       this.font = res.font;
/*  99 */       body().setWidth(796.0D).setHeight(height);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 104 */       int i = (int)MButt.clearWheelSpin();
/* 105 */       this.top -= i;
/*     */       
/* 107 */       if (this.top >= this.lines.length - 1)
/* 108 */         this.top = this.lines.length - 1; 
/* 109 */       if (this.top < 0) {
/* 110 */         this.top = 0;
/*     */       }
/* 112 */       int y1 = body().y1();
/* 113 */       int line = this.top;
/* 114 */       while (line < this.lines.length && y1 < body().y2()) {
/* 115 */         y1 = render(y1, this.lines[line], r, this.cols[line & 0x1]);
/* 116 */         line++;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private int render(int y1, CharSequence s, SPRITE_RENDERER r, COLOR color) {
/* 123 */       int start = 0;
/* 124 */       color.bind();
/*     */       do {
/* 126 */         int end = this.font.getEndIndex(s, start, body().width());
/* 127 */         int y2 = y1 + this.font.height();
/* 128 */         if (y2 < body().y2()) {
/* 129 */           if (start == 0) {
/* 130 */             if (s.length() > 0 && s.charAt(0) == '!') {
/* 131 */               start = 1;
/* 132 */               COLOR.BLUEISH.bind();
/* 133 */             } else if (s.length() > 0) {
/* 134 */               this.font.render(r, "-", body().x1(), y1);
/*     */             } 
/*     */           }
/*     */           
/* 138 */           this.font.render(r, s, body().x1() + 20, y1, start, end, 1.0D);
/*     */         } 
/*     */         
/* 141 */         y1 = y2;
/* 142 */         start = end;
/* 143 */       } while (start != s.length());
/*     */ 
/*     */       
/* 146 */       COLOR.unbind();
/* 147 */       return y1 + 2;
/*     */     }
/*     */     
/*     */     private CharSequence[] lines() {
/*     */       try {
/* 152 */         List<String> ss = Files.readAllLines((PATHS.BASE()).TXT.get("Patchnotes"));
/* 153 */         CharSequence[] res = new CharSequence[ss.size()];
/* 154 */         for (int i = 0; i < ss.size(); i++)
/* 155 */           res[i] = ss.get(i); 
/* 156 */         return res;
/* 157 */       } catch (IOException e) {
/*     */         
/* 159 */         e.printStackTrace();
/*     */ 
/*     */         
/* 162 */         return new CharSequence[] {
/* 163 */             "error"
/*     */           };
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenLog.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */