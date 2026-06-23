/*     */ package snake2d.util.sprite.text;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.Input;
/*     */ import snake2d.Mouse;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ public class StringInputSprite
/*     */   extends Input.CHAR_LISTENER implements SPRITE {
/*     */   private Font f;
/*     */   private static final String promt = "|";
/*     */   private CharSequence placeholder;
/*  19 */   public int marker = 0;
/*  20 */   private static final Str tmp = new Str(512);
/*     */   
/*  22 */   private int selectedI = -1;
/*     */   
/*     */   public StringInputSprite(int size, Font font) {
/*  25 */     super(size);
/*  26 */     this.f = font;
/*     */   }
/*     */   
/*     */   public StringInputSprite placeHolder(CharSequence ph) {
/*  30 */     this.placeholder = ph;
/*  31 */     return this;
/*     */   }
/*     */   
/*     */   public StringInputSprite font(Font f) {
/*  35 */     this.f = f;
/*  36 */     return this;
/*     */   }
/*     */   
/*     */   public Font font() {
/*  40 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void acceptChar(char c) {
/*  45 */     if (!listening())
/*     */       return; 
/*  47 */     if (this.selectedI >= 0 && this.selectedI != marker()) {
/*  48 */       int s = Math.min(this.selectedI, this.marker);
/*  49 */       int e = Math.max(this.selectedI, this.marker);
/*  50 */       tmp.clear().add(text());
/*  51 */       Str tt = text();
/*  52 */       tt.clear();
/*  53 */       for (int i = 0; i < tmp.length(); i++) {
/*  54 */         if (i == s) {
/*  55 */           tt.add(c);
/*  56 */         } else if (i < s || i > e) {
/*  57 */           tt.add(tmp.charAt(i));
/*     */         } 
/*  59 */       }  this.marker = s + 1;
/*  60 */     } else if (text().spaceLeft() > 0) {
/*  61 */       if (marker() == text().length()) {
/*  62 */         text().add(c);
/*     */       } else {
/*     */         
/*  65 */         tmp.clear().add(text());
/*  66 */         text().clear();
/*  67 */         int k = 0;
/*  68 */         for (int i = 0; i < tmp.length(); i++) {
/*  69 */           if (k++ == this.marker) {
/*  70 */             text().add(c);
/*  71 */             i--;
/*     */           } else {
/*  73 */             text().add(tmp.charAt(i));
/*     */           } 
/*     */         } 
/*     */       } 
/*  77 */       this.marker++;
/*     */     } 
/*     */     
/*  80 */     change();
/*     */     
/*  82 */     this.selectedI = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void backspace() {
/*  88 */     if (!listening())
/*     */       return; 
/*  90 */     if (text().length() == 0)
/*     */       return; 
/*  92 */     int m = marker();
/*  93 */     if (!removeSelected())
/*     */     {
/*  95 */       if (m > 0) {
/*     */         
/*  97 */         tmp.clear().add(text());
/*  98 */         Str tt = text();
/*  99 */         tt.clear();
/* 100 */         for (int i = 0; i < tmp.length(); i++) {
/* 101 */           if (i + 1 != m)
/*     */           {
/*     */             
/* 104 */             tt.add(tmp.charAt(i));
/*     */           }
/*     */         } 
/* 107 */         this.marker--;
/*     */       } 
/*     */     }
/* 110 */     this.selectedI = -1;
/* 111 */     change();
/*     */   }
/*     */ 
/*     */   
/*     */   public void del() {
/* 116 */     if (!listening())
/*     */       return; 
/* 118 */     if (text().length() == 0)
/*     */       return; 
/* 120 */     int m = marker();
/* 121 */     if (!removeSelected())
/*     */     {
/* 123 */       if (m > 0) {
/*     */         
/* 125 */         tmp.clear().add(text());
/* 126 */         Str tt = text();
/* 127 */         tt.clear();
/* 128 */         for (int i = 0; i < tmp.length(); i++) {
/* 129 */           if (i != m)
/*     */           {
/*     */             
/* 132 */             tt.add(tmp.charAt(i)); } 
/*     */         } 
/*     */       } 
/*     */     }
/* 136 */     this.selectedI = -1;
/* 137 */     change();
/*     */   }
/*     */   
/*     */   private boolean removeSelected() {
/* 141 */     if (!listening())
/* 142 */       return false; 
/* 143 */     if (text().length() == 0)
/* 144 */       return false; 
/* 145 */     int m = marker();
/* 146 */     if (this.selectedI >= 0 && this.selectedI != m) {
/* 147 */       int s = Math.min(this.selectedI, this.marker);
/* 148 */       int e = Math.max(this.selectedI, this.marker);
/* 149 */       tmp.clear().add(text());
/* 150 */       Str tt = text();
/* 151 */       tt.clear();
/* 152 */       for (int i = 0; i < tmp.length(); i++) {
/* 153 */         if (i < s || i >= e)
/* 154 */           tt.add(tmp.charAt(i)); 
/*     */       } 
/* 156 */       return true;
/*     */     } 
/* 158 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void left(boolean mod) {
/* 163 */     if (mod) {
/* 164 */       if (this.selectedI >= 0) {
/* 165 */         this.selectedI--;
/*     */       } else {
/* 167 */         this.selectedI = this.marker - 1;
/* 168 */       }  if (this.selectedI < 0)
/* 169 */         this.selectedI = 0; 
/* 170 */     } else if (this.selectedI >= 0) {
/* 171 */       this.marker = this.selectedI;
/* 172 */       this.selectedI = -1;
/*     */     } else {
/* 174 */       this.selectedI = -1;
/* 175 */       this.marker--;
/* 176 */       if (this.marker < 0) {
/* 177 */         this.marker = 0;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void right(boolean mod) {
/* 183 */     if (mod) {
/* 184 */       if (this.selectedI >= 0) {
/* 185 */         this.selectedI++;
/*     */       } else {
/* 187 */         this.selectedI = this.marker + 1;
/* 188 */       }  if (this.selectedI > text().length())
/* 189 */         this.selectedI = text().length(); 
/* 190 */     } else if (this.selectedI >= 0) {
/* 191 */       this.marker = this.selectedI;
/* 192 */       this.selectedI = -1;
/*     */     } else {
/*     */       
/* 195 */       this.marker++;
/* 196 */       if (this.marker > text().length()) {
/* 197 */         this.marker = text().length();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void click(int x1) {
/* 203 */     this.marker = findX(x1);
/* 204 */     this.selectedI = -1;
/*     */   }
/*     */   
/*     */   public void select(int x) {
/* 208 */     this.selectedI = -1;
/* 209 */     this.selectedI = findX(x);
/*     */   }
/*     */   
/*     */   public void selectAll() {
/* 213 */     this.marker = 0;
/* 214 */     this.selectedI = text().length();
/*     */   }
/*     */   
/*     */   private int findX(int x1) {
/* 218 */     int x = 0;
/* 219 */     int m = marker();
/*     */     
/* 221 */     if (text().length() == 0) {
/* 222 */       return 0;
/*     */     }
/*     */     
/*     */     int i;
/* 226 */     for (i = 0; i < m; i++) {
/* 227 */       int w = width(i);
/* 228 */       x += w;
/* 229 */       if (x - w / 2 >= x1) {
/* 230 */         return i;
/*     */       }
/*     */     } 
/* 233 */     if (this.selectedI < 0) {
/* 234 */       x += this.f.width("|".charAt(0), 1.0D) + 8;
/* 235 */       if (x > x1) {
/* 236 */         return m;
/*     */       }
/*     */     } 
/*     */     
/* 240 */     for (i = m; i < text().length(); i++) {
/* 241 */       int w = width(i);
/* 242 */       x += w;
/* 243 */       if (x - w / 2 >= x1) {
/* 244 */         return i;
/*     */       }
/*     */     } 
/* 247 */     return text().length();
/*     */   }
/*     */   
/*     */   private int width(int index) {
/* 251 */     int w = this.f.width(text().charAt(index), 1.0D);
/* 252 */     if (index > 0)
/* 253 */       w -= this.f.getBack(text().charAt(index - 1), text().charAt(index), 1.0D); 
/* 254 */     return w;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int width() {
/* 260 */     if (text().length() == 0) {
/* 261 */       if (this.placeholder != null && !listening()) {
/* 262 */         return this.f.getDim(this.placeholder).x();
/*     */       }
/* 264 */       return 0;
/*     */     } 
/* 266 */     return this.f.getDim(text()).x();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void enter() {
/* 271 */     Mouse.currentClicked = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 276 */     return this.f.height();
/*     */   }
/*     */   
/*     */   private int marker() {
/* 280 */     if (this.marker > text().length())
/* 281 */       this.marker = text().length(); 
/* 282 */     if (this.marker < 0)
/* 283 */       this.marker = 0; 
/* 284 */     return this.marker;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 290 */     int marker = marker();
/* 291 */     tmp.clear().add(text());
/* 292 */     this.selectedI = CLAMP.i(this.selectedI, -1, tmp.length());
/*     */     
/* 294 */     renAction();
/*     */ 
/*     */     
/* 297 */     if (!listening()) {
/* 298 */       if (tmp.length() == 0 && this.placeholder != null) {
/* 299 */         COLOR.WHITE65.bind();
/* 300 */         this.f.render(r, this.placeholder, X1, Y1, X2 - X1, 1.0D);
/* 301 */         COLOR.unbind();
/*     */       } else {
/* 303 */         this.f.render(r, tmp, X1, Y1, X2 - X1, 1.0D);
/*     */       } 
/* 305 */     } else if (this.selectedI >= 0 && this.selectedI != marker) {
/* 306 */       int i1 = Math.min(marker, this.selectedI);
/* 307 */       int i2 = Math.max(marker, this.selectedI);
/*     */       
/* 309 */       int sx1 = X1 + this.f.getDim(tmp, 0, i1, 2147483647, 1.0D).x() - 2;
/* 310 */       int sx2 = sx1 + this.f.getDim(tmp, i1, i2, 2147483647, 1.0D).x() + 2;
/* 311 */       COLOR.WHITE50.render(r, sx1, sx2, Y1, Y2);
/* 312 */       this.f.render(r, tmp, X1, Y1, X2 - X1, 1.0D);
/*     */     } else {
/* 314 */       this.f.render((SPRITE_RENDERER)CORE.renderer(), tmp, X1, Y1, 0, marker, 1.0D);
/*     */       
/* 316 */       X1 += this.f.getDim(text(), 0, marker, 2147483647, 1.0D).x() + 4;
/* 317 */       COLOR.BLACK2WHITE.bind();
/* 318 */       this.f.render(r, "|", X1, Y1);
/* 319 */       COLOR.unbind();
/* 320 */       X1 += 4;
/* 321 */       if (marker() < tmp.length()) {
/* 322 */         this.f.render((SPRITE_RENDERER)CORE.renderer(), tmp, X1, Y1, marker, text().length(), 1.0D);
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
/*     */ 
/*     */   
/*     */   public void renAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void change() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputClickable c(DIR d) {
/* 363 */     return new InputClickable(this, d);
/*     */   }
/*     */   
/*     */   public static class InputClickable
/*     */     extends CLICKABLE.ClickableAbs {
/*     */     private final StringInputSprite input;
/* 369 */     private COLOR hoverC = COLOR.WHITE2WHITE;
/* 370 */     private COLOR color = COLOR.WHITE100;
/* 371 */     private COLOR active = (COLOR)this.color.shade(0.7D);
/*     */     private DIR rep;
/*     */     
/*     */     InputClickable(StringInputSprite input, DIR rep) {
/* 375 */       this.input = input;
/* 376 */       while (input.text().spaceLeft() > 0) {
/* 377 */         input.text().add('n');
/*     */       }
/* 379 */       int w = input.width();
/* 380 */       this.body.setWidth(w);
/* 381 */       this.body.setHeight(input.height());
/* 382 */       input.text().clear();
/* 383 */       this.rep = rep;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 389 */       this.input.renAction();
/* 390 */       if (Mouse.currentClicked == this) {
/* 391 */         this.input.listen();
/*     */       }
/* 393 */       int dx = (body().width() - this.input.width()) / 2;
/*     */       
/* 395 */       int x1 = body().x1() + (this.rep.x() + 1) * dx;
/* 396 */       if (!isActive)
/* 397 */         this.active.bind(); 
/* 398 */       if (isHovered || Mouse.currentClicked == this) {
/* 399 */         this.hoverC.bind();
/*     */       } else {
/* 401 */         this.color.bind();
/* 402 */       }  this.input.render(r, x1, this.body.y1());
/* 403 */       COLOR.unbind();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean click() {
/* 408 */       if (super.click()) {
/* 409 */         Mouse.currentClicked = (CLICKABLE)this;
/* 410 */         this.input.listen();
/* 411 */         this.input.marker = this.input.text().length();
/* 412 */         return true;
/*     */       } 
/* 414 */       return false;
/*     */     }
/*     */     
/*     */     public void focus() {
/* 418 */       Mouse.currentClicked = (CLICKABLE)this;
/* 419 */       this.input.listen();
/*     */     }
/*     */     
/*     */     public InputClickable colors(COLOR normal, COLOR hover) {
/* 423 */       this.hoverC = hover;
/* 424 */       this.color = normal;
/* 425 */       this.active = (COLOR)this.color.shade(0.7D);
/* 426 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\text\StringInputSprite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */