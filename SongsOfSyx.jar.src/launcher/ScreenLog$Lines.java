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
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.text.Font;
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
/*     */ class Lines
/*     */   extends RENDEROBJ.RenderImp
/*     */ {
/*  87 */   private CharSequence[] lines = lines();
/*  88 */   int top = 0;
/*  89 */   private final String sep = "-";
/*  90 */   private final COLOR[] cols = new COLOR[] {
/*  91 */       COLOR.WHITE100, 
/*  92 */       (COLOR)new ColorImp(127, 110, 100)
/*     */     };
/*     */   
/*     */   private final Font font;
/*     */   
/*     */   Lines(RES res, int height) {
/*  98 */     this.font = res.font;
/*  99 */     body().setWidth(796.0D).setHeight(height);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 104 */     int i = (int)MButt.clearWheelSpin();
/* 105 */     this.top -= i;
/*     */     
/* 107 */     if (this.top >= this.lines.length - 1)
/* 108 */       this.top = this.lines.length - 1; 
/* 109 */     if (this.top < 0) {
/* 110 */       this.top = 0;
/*     */     }
/* 112 */     int y1 = body().y1();
/* 113 */     int line = this.top;
/* 114 */     while (line < this.lines.length && y1 < body().y2()) {
/* 115 */       y1 = render(y1, this.lines[line], r, this.cols[line & 0x1]);
/* 116 */       line++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int render(int y1, CharSequence s, SPRITE_RENDERER r, COLOR color) {
/* 123 */     int start = 0;
/* 124 */     color.bind();
/*     */     do {
/* 126 */       int end = this.font.getEndIndex(s, start, body().width());
/* 127 */       int y2 = y1 + this.font.height();
/* 128 */       if (y2 < body().y2()) {
/* 129 */         if (start == 0) {
/* 130 */           if (s.length() > 0 && s.charAt(0) == '!') {
/* 131 */             start = 1;
/* 132 */             COLOR.BLUEISH.bind();
/* 133 */           } else if (s.length() > 0) {
/* 134 */             this.font.render(r, "-", body().x1(), y1);
/*     */           } 
/*     */         }
/*     */         
/* 138 */         this.font.render(r, s, body().x1() + 20, y1, start, end, 1.0D);
/*     */       } 
/*     */       
/* 141 */       y1 = y2;
/* 142 */       start = end;
/* 143 */     } while (start != s.length());
/*     */ 
/*     */     
/* 146 */     COLOR.unbind();
/* 147 */     return y1 + 2;
/*     */   }
/*     */   
/*     */   private CharSequence[] lines() {
/*     */     try {
/* 152 */       List<String> ss = Files.readAllLines((PATHS.BASE()).TXT.get("Patchnotes"));
/* 153 */       CharSequence[] res = new CharSequence[ss.size()];
/* 154 */       for (int i = 0; i < ss.size(); i++)
/* 155 */         res[i] = ss.get(i); 
/* 156 */       return res;
/* 157 */     } catch (IOException e) {
/*     */       
/* 159 */       e.printStackTrace();
/*     */ 
/*     */       
/* 162 */       return new CharSequence[] {
/* 163 */           "error"
/*     */         };
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenLog$Lines.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */