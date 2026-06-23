/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.StatDecree;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.slider.GTarget;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ 
/*     */ public class StatRow
/*     */   extends GuiSection {
/*     */   private final STAT s;
/*     */   private final HCLASS cl;
/*     */   private final GETTER<Race> race;
/*     */   static final int StatX = 268;
/*     */   static final int MeterX = 328;
/*     */   static final int MeterW = 200;
/*     */   static final int Width = 532;
/*     */   
/*     */   StatRow(STAT s, HCLASS cl, GETTER<Race> race) {
/*  43 */     this(s, (RENDEROBJ)null, cl, race);
/*     */   }
/*     */   
/*     */   StatRow(final STAT s, RENDEROBJ ins, final HCLASS cl, final GETTER<Race> race) {
/*  47 */     this.s = s;
/*  48 */     this.cl = cl;
/*  49 */     this.race = race;
/*  50 */     add((RENDEROBJ)new Arrow(s, cl, race));
/*     */     
/*  52 */     if (ins != null) {
/*  53 */       addRightC(2, ins);
/*     */     }
/*  55 */     SPRITE icon = (s.info()).icon;
/*  56 */     if (icon != null) {
/*  57 */       addRightC(2, icon.resized(32));
/*     */     }
/*  59 */     GText t = new GText((UI.FONT()).H2, (s.info()).name);
/*  60 */     t.setMultipleLines(false);
/*  61 */     t.setMaxWidth(210 - ((icon != null) ? 36 : 0));
/*  62 */     addRightC(2, (SPRITE)t.lablify());
/*  63 */     add((SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  67 */             StatRow.format(text, s, StatRow.this.value(cl, 0), cl, (Race)race.get());
/*     */           }
/*  69 */         }268, 0);
/*  70 */     add((RENDEROBJ)new Meter(s, cl, race), 328, 0);
/*  71 */     degree(cl, race);
/*  72 */     pad(2, 4);
/*     */   }
/*     */   
/*     */   static class Arrow
/*     */     extends RENDEROBJ.RenderImp {
/*     */     private final STAT s;
/*     */     private final HCLASS cl;
/*     */     private final GETTER<Race> race;
/*     */     
/*     */     Arrow(STAT s, HCLASS cl, GETTER<Race> race) {
/*  82 */       super(16);
/*  83 */       this.s = s;
/*  84 */       this.cl = cl;
/*  85 */       this.race = race;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/*  90 */       int v = (int)(this.s.standing().getHistoric(this.cl, (Race)this.race.get(), 1) * 256.0D);
/*  91 */       int n = (int)(this.s.standing().get(this.cl, (Race)this.race.get()) * 256.0D);
/*  92 */       if (n > v) {
/*  93 */         GCOLOR.UI().goodFlash().bind();
/*  94 */         (SPRITES.icons()).s.arrow_right.render(r, (RECTANGLE)this.body);
/*  95 */       } else if (n < v) {
/*  96 */         GCOLOR.UI().badFlash().bind();
/*  97 */         (SPRITES.icons()).s.arrow_left.render(r, (RECTANGLE)this.body);
/*     */       } 
/*  99 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */   
/*     */   static class Meter
/*     */     extends RENDEROBJ.RenderImp
/*     */   {
/*     */     private final STAT s;
/*     */     private final HCLASS cl;
/*     */     private final GETTER<Race> race;
/*     */     
/*     */     Meter(STAT s, HCLASS cl, GETTER<Race> race) {
/* 111 */       this.s = s;
/* 112 */       body().setDim(200.0D, 16.0D);
/* 113 */       this.cl = cl;
/* 114 */       this.race = race;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 119 */       double now = this.s.standing().get(this.cl, (Race)this.race.get());
/* 120 */       double max = this.s.standing().max(this.cl, (Race)this.race.get());
/* 121 */       double prev = this.s.standing().getPrev(this.cl, (Race)this.race.get(), 8);
/* 122 */       int w = (int)(200.0D * Math.sqrt(this.s.standing().normalized(this.cl, (Race)this.race.get())));
/* 123 */       if (w > 0) {
/* 124 */         GMeter.renderDelta(r, prev / max, now / max, body().x1(), body().x1() + w, body().y1(), body().y2());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   void degree(final HCLASS cl, final GETTER<Race> race) {
/* 131 */     final StatDecree c = this.s.decree();
/*     */     
/* 133 */     if (c == null)
/*     */       return; 
/* 135 */     final INT_O.INT_OE<Race> rr = c.getI(cl);
/* 136 */     if (rr.max(null) == 1) {
/* 137 */       GButt.Checkbox b = new GButt.Checkbox((SPRITE)(new GText((UI.FONT()).S, c.name)).lablifySub())
/*     */         {
/*     */           protected void renAction()
/*     */           {
/* 141 */             selectedSet((rr.get(race.get()) == 1));
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 146 */             rr.set(race.get(), rr.get(race.get()) + 1 & 0x1);
/*     */           }
/*     */         };
/* 149 */       b.hoverSet((INFO)c);
/* 150 */       b.body().moveX1Y1(64.0D, (getLastY2() + 8));
/* 151 */       add((RENDEROBJ)b);
/* 152 */     } else if (rr.max(null) > 25) {
/* 153 */       INT.INTE d = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 157 */             return rr.min(race.get());
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 162 */             return rr.max(race.get());
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 167 */             return rr.get(race.get());
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 172 */             rr.set(race.get(), t);
/*     */           }
/*     */         };
/*     */       
/* 176 */       GSliderInt in = new GSliderInt(d, 100, true, true)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 179 */             GBox b = (GBox)text;
/* 180 */             b.add((SPRITE)GFORMAT.f(b.text(), c.get(cl, (Race)race.get())));
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 186 */       add((SPRITE)(new GText((UI.FONT()).S, c.name)).lablifySub(), 64, getLastY2() + 8);
/* 187 */       addRightC(8, (RENDEROBJ)in);
/*     */     } else {
/*     */       
/* 190 */       INT.INTE d = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 194 */             return rr.min(race.get());
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 199 */             return rr.max(race.get());
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 204 */             return rr.get(race.get());
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 209 */             rr.set(race.get(), t);
/*     */           }
/*     */         };
/*     */       
/* 213 */       GStat ss = new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 217 */             GFORMAT.f(text, c.get(cl, (Race)race.get()), 1);
/*     */           }
/*     */         };
/*     */       
/* 221 */       GTarget m = new GTarget(64, false, true, ss, d);
/* 222 */       m.hoverTitleSet(c.name);
/* 223 */       m.hoverInfoSet(c.desc);
/* 224 */       add((SPRITE)(new GText((UI.FONT()).S, c.name)).lablifySub(), 64, getLastY2() + 8);
/* 225 */       addRightC(8, (RENDEROBJ)m);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static GText format(GText t, STAT s, double v, HCLASS cl, Race race) {
/* 232 */     if (race == null) {
/* 233 */       if (s.info().isInt()) {
/* 234 */         return GFORMAT.f(t, v * s.dataDivider());
/*     */       }
/* 236 */       return GFORMAT.perc(t, v).normalify();
/*     */     } 
/*     */ 
/*     */     
/* 240 */     double d = (race.stats().def(s.standing()).get(cl)).to - (race.stats().def(s.standing()).get(cl)).from;
/* 241 */     if (s.info().isInt()) {
/* 242 */       double m = s.dataDivider();
/* 243 */       double n = v * s.dataDivider();
/*     */       
/* 245 */       if (d > 0.0D)
/* 246 */         return GFORMAT.f0(t, n, m); 
/* 247 */       if (d < 0.0D) {
/* 248 */         return GFORMAT.f0Inv(t, n, m);
/*     */       }
/* 250 */       return GFORMAT.f(t, n);
/*     */     } 
/*     */     
/* 253 */     if (d > 0.0D)
/* 254 */       return GFORMAT.perc(t, v); 
/* 255 */     if (d < 0.0D) {
/* 256 */       return GFORMAT.percInv(t, v);
/*     */     }
/* 258 */     return GFORMAT.perc(t, v).normalify();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 266 */     super.render(r, ds);
/* 267 */     GCOLOR.UI().border().render(r, body().x1(), body().x2(), body().y2() - 1, body().y2());
/*     */   }
/*     */ 
/*     */   
/*     */   protected double value(HCLASS c, int daysBack) {
/* 272 */     return this.s.data(c).getD(this.race.get(), daysBack);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 277 */     if (isHoveringAHoverElement()) {
/* 278 */       super.hoverInfoGet(text);
/*     */       
/*     */       return;
/*     */     } 
/* 282 */     this.s.hover(text, this.cl, (Race)this.race.get());
/*     */   }
/*     */   
/*     */   static class Title
/*     */     extends HOVERABLE.HoverableAbs
/*     */   {
/*     */     private final GText t;
/*     */     
/*     */     Title(INFO info) {
/* 291 */       this(info.name, info.desc);
/*     */     }
/*     */     
/*     */     Title(CharSequence name, CharSequence desc) {
/* 295 */       this.t = (new GText((UI.FONT()).H2, name)).lablify();
/* 296 */       body().setWidth(500.0D);
/* 297 */       body().setHeight((this.t.height() * 2));
/* 298 */       hoverTitleSet(name);
/* 299 */       hoverInfoSet(desc);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 305 */       this.t.renderC(r, body().cX(), body().cY() + this.t.height() / 2 - 6);
/* 306 */       COLOR.WHITE30.render(r, body().x1(), body().x2(), body().y2() - 1, body().y2());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\StatRow.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */