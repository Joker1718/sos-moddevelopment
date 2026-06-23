/*     */ package snake2d.util.misc;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.CoreStats;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ 
/*     */ public class StatsDebugger
/*     */ {
/*     */   private final Font font;
/*     */   private final int size;
/*     */   
/*     */   public static abstract class Formatter {
/*     */     private Formatter() {}
/*     */     
/*     */     abstract char[] getFormat(double param1Double);
/*  22 */     public static final Formatter PERCENTAGE = new Formatter()
/*     */       {
/*     */         private final char[] chars;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         char[] getFormat(double v) {
/*  30 */           int d = (int)(v * 100.0D);
/*     */           
/*  32 */           this.chars[5] = (char)(48 + d % 10);
/*  33 */           d /= 10;
/*  34 */           this.chars[4] = (char)(48 + d % 10);
/*  35 */           d /= 10;
/*  36 */           this.chars[2] = (char)(48 + d % 10);
/*  37 */           d /= 10;
/*  38 */           this.chars[1] = (char)(48 + d % 10);
/*  39 */           d /= 10;
/*  40 */           this.chars[0] = (char)(48 + d % 10);
/*     */           
/*  42 */           return this.chars;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  47 */     public static final Formatter Amount = new Formatter()
/*     */       {
/*  49 */         private final char[] chars = new char[11];
/*     */ 
/*     */         
/*     */         char[] getFormat(double v) {
/*  53 */           int d = (int)v;
/*     */           
/*  55 */           this.chars[10] = (char)(48 + d % 10); d /= 10;
/*  56 */           this.chars[9] = (char)(48 + d % 10); d /= 10;
/*  57 */           this.chars[8] = (char)(48 + d % 10); d /= 10;
/*  58 */           this.chars[7] = '.';
/*  59 */           this.chars[6] = (char)(48 + d % 10); d /= 10;
/*  60 */           this.chars[5] = (char)(48 + d % 10); d /= 10;
/*  61 */           this.chars[4] = (char)(48 + d % 10); d /= 10;
/*  62 */           this.chars[3] = '.';
/*  63 */           this.chars[2] = (char)(48 + d % 10); d /= 10;
/*  64 */           this.chars[1] = (char)(48 + d % 10); d /= 10;
/*  65 */           this.chars[0] = (char)(48 + d % 10); d /= 10;
/*     */           
/*  67 */           return this.chars;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean show = false;
/*     */ 
/*     */   
/*  77 */   private final ArrayList<Value> values = new ArrayList(150);
/*     */   
/*     */   public StatsDebugger(Font font) {
/*  80 */     this.font = font;
/*  81 */     this.size = font.height();
/*     */     
/*  83 */     this.values.add(getCoreValue(CoreStats.FPS, 0, Formatter.Amount));
/*  84 */     this.values.add(getCoreValue(CoreStats.coreTotal, 0, Formatter.PERCENTAGE));
/*  85 */     this.values.add(getCoreValue(CoreStats.coreFlush, 25, Formatter.PERCENTAGE));
/*  86 */     this.values.add(getCoreValue(CoreStats.corePoll, 25, Formatter.PERCENTAGE));
/*  87 */     this.values.add(getCoreValue(CoreStats.coreSound, 25, Formatter.PERCENTAGE));
/*  88 */     this.values.add(getCoreValue(CoreStats.coreSleep, 25, Formatter.PERCENTAGE));
/*  89 */     this.values.add(getCoreValue(CoreStats.coreFinish, 25, Formatter.PERCENTAGE));
/*  90 */     this.values.add(getCoreValue(CoreStats.swapPercentage, 0, Formatter.PERCENTAGE));
/*  91 */     this.values.add(getCoreValue(CoreStats.totalPercentage, 0, Formatter.PERCENTAGE));
/*  92 */     this.values.add(getCoreValue(CoreStats.renderPercentage, 25, Formatter.PERCENTAGE));
/*  93 */     this.values.add(getCoreValue(CoreStats.updatePercentage, 25, Formatter.PERCENTAGE));
/*     */     
/*  95 */     this.values.add(getCoreValue(CoreStats.smallUpdates, 0, Formatter.Amount));
/*  96 */     this.values.add(getCoreValue(CoreStats.droppedTicks, 0, Formatter.Amount));
/*  97 */     this.values.add(getCoreValue(CoreStats.heap, 0, Formatter.Amount));
/*  98 */     this.values.add(getCoreValue(CoreStats.usedHeap, 0, Formatter.Amount));
/*  99 */     this.values.add(getCoreValue(CoreStats.heapGrowth, 0, Formatter.Amount));
/* 100 */     this.values.add(new Value(this, "sprites", 0, Formatter.Amount)
/*     */         {
/*     */           protected double getValue() {
/* 103 */             return CORE.renderer().getSpritesSprocessed();
/*     */           }
/*     */         });
/* 106 */     this.values.add(new Value(this, "shadows", 0, Formatter.Amount)
/*     */         {
/*     */           protected double getValue() {
/* 109 */             return CORE.renderer().getShadowsRendered();
/*     */           }
/*     */         });
/* 112 */     this.values.add(new Value(this, "lights", 0, Formatter.Amount)
/*     */         {
/*     */           protected double getValue() {
/* 115 */             return CORE.renderer().getLightsProcessed();
/*     */           }
/*     */         });
/* 118 */     this.values.add(new Value(this, "particles", 0, Formatter.Amount)
/*     */         {
/*     */           protected double getValue() {
/* 121 */             return CORE.renderer().getParticlesProcessed();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(Value value) {
/* 128 */     this.values.add(value);
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() {
/* 133 */     if (!this.show) {
/*     */       return;
/*     */     }
/* 136 */     AmbientLight.full.register(0, (CORE.getGraphics()).nativeWidth, 0, (CORE.getGraphics()).nativeHeight);
/*     */     
/* 138 */     int y1 = this.size;
/* 139 */     int x1 = this.size;
/*     */     
/* 141 */     for (Value v : this.values) {
/* 142 */       v.render((SPRITE_RENDERER)CORE.renderer(), x1, y1);
/* 143 */       y1 += this.size;
/* 144 */       if (y1 + this.size >= (CORE.getGraphics()).nativeHeight) {
/* 145 */         y1 = this.size;
/* 146 */         x1 += 300;
/*     */       } 
/*     */     } 
/*     */     
/* 150 */     CORE.renderer().newLayer(false, 0);
/*     */   }
/*     */   
/*     */   public void toggle() {
/* 154 */     this.show ^= 0x1;
/*     */   }
/*     */   
/*     */   public boolean isToggled() {
/* 158 */     return this.show;
/*     */   }
/*     */   
/*     */   public void show() {
/* 162 */     this.show = true;
/*     */   }
/*     */   
/*     */   public void hide() {
/* 166 */     this.show = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private Value getCoreValue(final CoreStats.Value v, int off, Formatter f) {
/* 171 */     return new Value(this, v.getLabel(), off, f)
/*     */       {
/*     */         protected double getValue()
/*     */         {
/* 175 */           return v.ave;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract class Value
/*     */   {
/* 183 */     private double last = -1.0D;
/*     */     private final SPRITE label;
/* 185 */     private final Text value = new Text(StatsDebugger.this.font, 16);
/*     */     private final int off;
/*     */     private final StatsDebugger.Formatter format;
/*     */     
/*     */     public Value(String label, int off, StatsDebugger.Formatter f) {
/* 190 */       this.label = StatsDebugger.this.font.getText(label);
/* 191 */       this.off = off;
/* 192 */       this.format = f;
/*     */     }
/*     */     
/*     */     Value(CoreStats.Value v, StatsDebugger.Formatter f) {
/* 196 */       this(v.getLabel(), 0, f);
/* 197 */       setValue(v.ave);
/*     */     }
/*     */     
/*     */     void render(SPRITE_RENDERER r, int x, int y) {
/* 201 */       double val = getValue();
/* 202 */       if (val != this.last) {
/* 203 */         setValue(val);
/*     */       }
/* 205 */       COLOR.WHITE65.bind();
/* 206 */       this.label.render(r, x + this.off, y);
/* 207 */       COLOR.unbind();
/* 208 */       this.value.render(r, x + this.off + 150, y);
/*     */     }
/*     */     
/*     */     private void setValue(double val) {
/* 212 */       this.last = val;
/*     */       
/* 214 */       char[] d = this.format.getFormat(val);
/* 215 */       this.value.clear();
/* 216 */       for (int i = 0; i < d.length; i++) {
/* 217 */         this.value.add(d[i]);
/*     */       }
/* 219 */       this.value.adjustWidth();
/*     */     }
/*     */     
/*     */     protected abstract double getValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\misc\StatsDebugger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */