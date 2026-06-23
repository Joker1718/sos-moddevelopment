/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.RDOutputs;
/*     */ 
/*     */ final class PlayOutput extends GuiSection {
/*  33 */   private static CharSequence ¤¤ship = "This resource is shipped annually in {0} days. Accumulated so far: {1}.";
/*     */   static {
/*  35 */     D.ts(PlayOutput.class);
/*     */   }
/*  37 */   private final ArrayListGrower<ResButt> butts = new ArrayListGrower();
/*     */   
/*     */   private final GETTER.GETTER_IMP<Region> g;
/*     */   
/*     */   private final ArrayList<RENDEROBJ> activeButts;
/*     */   
/*     */   private final int width;
/*     */   public static final int height = 30;
/*     */   private final int amX;
/*     */   
/*     */   public PlayOutput(final GETTER.GETTER_IMP<Region> g, int width) {
/*  48 */     GButt.ButtPanel buttPanel = new GButt.ButtPanel(RDOutputs.¤¤Squeeze)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  52 */           RD.OUTPUT().squeze((Region)g.get());
/*  53 */           super.clickA();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  59 */           activeSet((!RD.BUILDINGS().isTmp() && (RD.DEVASTATION()).current.getD(g.get()) < 0.25D));
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  64 */           GBox b = (GBox)text;
/*  65 */           b.title(RDOutputs.¤¤Squeeze);
/*  66 */           b.text(RDOutputs.¤¤SqueezeD);
/*  67 */           b.NL();
/*     */           
/*  69 */           b.add((SPRITE)(UI.icons()).s.money);
/*  70 */           b.textLL(Dic.¤¤Currs);
/*  71 */           b.tab(6);
/*  72 */           RD.OUTPUT().getClass(); b.add((SPRITE)GFORMAT.iIncr(b.text(), (long)((RD.OUTPUT()).MONEY.boost.get((BOOSTABLE_O)g.get()) * 4.0D)));
/*  73 */           b.NL();
/*     */           
/*  75 */           for (RDOutputs.RDResource res : (RD.OUTPUT()).RES) {
/*  76 */             RD.OUTPUT().getClass(); int am = (int)(res.boostYearlyPart.get((BOOSTABLE_O)g.get()) * 4.0D / TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/*  77 */             RD.OUTPUT().getClass(); am = (int)(am + res.boost.get((BOOSTABLE_O)g.get()) * 4.0D);
/*  78 */             if (am > 0) {
/*  79 */               b.add(res.res.icon());
/*  80 */               b.textLL(res.res.name);
/*  81 */               b.tab(6);
/*  82 */               b.add((SPRITE)GFORMAT.iIncr(b.text(), am));
/*  83 */               b.NL();
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  90 */           b.textLL(((RD.DEVASTATION()).current.info()).name);
/*  91 */           b.tab(6);
/*  92 */           b.add((SPRITE)GFORMAT.perc(b.text(), -0.5D));
/*  93 */           b.NL();
/*  94 */           b.textLL(((RD.RACES()).loyaltyAll.info()).name);
/*  95 */           b.tab(6);
/*  96 */           b.add((SPRITE)GFORMAT.perc(b.text(), -0.4D));
/*  97 */           b.NL();
/*  98 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 103 */     buttPanel.body().moveX2((body().x2() - 16));
/* 104 */     buttPanel.body().moveY1(4.0D);
/* 105 */     add((RENDEROBJ)buttPanel);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     this.width = (width - 32) / 5;
/* 111 */     this.g = g;
/* 112 */     for (int i = 0; i < (RD.OUTPUT()).ALL.size(); i++) {
/* 113 */       this.butts.add(new ResButt((RDOutputs.RDOutput)(RD.OUTPUT()).ALL.get(i)));
/*     */     }
/* 115 */     this.activeButts = new ArrayList(this.butts.size());
/*     */ 
/*     */     
/* 118 */     this.amX = 5;
/* 119 */     GTableBuilder builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/* 123 */           return (int)Math.ceil(PlayOutput.this.activeButts.size() / PlayOutput.this.amX);
/*     */         }
/*     */       };
/*     */     
/* 127 */     builder.column(null, this.amX * this.width, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/* 131 */             return (RENDEROBJ)new PlayOutput.Row(ier);
/*     */           }
/*     */         });
/*     */     
/* 135 */     addRelBody(2, DIR.S, (RENDEROBJ)builder.createHeight(60, false));
/*     */ 
/*     */     
/* 138 */     pad(6, 6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 143 */     GButt.ButtPanel.renderBG(r, true, false, false, (RECTANGLE)body());
/* 144 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/* 145 */     this.activeButts.clearSloppy();
/* 146 */     for (ResButt b : this.butts) {
/*     */       
/* 148 */       if (hasValue(b.bu.boost, (Region)this.g.get()) || hasValue(b.bu.boostYearlyPart, (Region)this.g.get())) {
/* 149 */         this.activeButts.add(b);
/*     */       }
/*     */     } 
/* 152 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean hasValue(Boostable bo, Region reg) {
/* 157 */     for (Booster b : bo.all()) {
/* 158 */       double v = b.get(reg);
/* 159 */       if (!b.isMul && v > 0.0D) {
/* 160 */         return true;
/*     */       }
/*     */     } 
/* 163 */     return false;
/*     */   }
/*     */   
/*     */   private class Row
/*     */     extends GuiSection {
/*     */     private final GETTER<Integer> ier;
/*     */     
/*     */     Row(GETTER<Integer> ier) {
/* 171 */       this.ier = ier;
/* 172 */       body().setHeight(30.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 177 */       int x1 = body().x1();
/* 178 */       int y1 = body().y1();
/* 179 */       clear();
/* 180 */       int s = ((Integer)this.ier.get()).intValue() * PlayOutput.this.amX;
/* 181 */       for (int i = 0; i < PlayOutput.this.amX && i + s < PlayOutput.this.activeButts.size(); i++) {
/* 182 */         addRightC(0, (RENDEROBJ)PlayOutput.this.activeButts.get(i + s));
/*     */       }
/* 184 */       body().moveX1(x1);
/* 185 */       body().moveY1(y1);
/* 186 */       super.render(r, ds);
/*     */     }
/*     */   }
/*     */   
/*     */   private class ResButt
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private final RDOutputs.RDOutput bu;
/* 194 */     private final GText tt = new GText((UI.FONT()).S, 8);
/*     */     
/*     */     ResButt(RDOutputs.RDOutput b) {
/* 197 */       this.body.setDim(PlayOutput.this.width, 30.0D);
/* 198 */       this.bu = b;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 204 */       GCOLOR.UI().border().render(r, (RECTANGLE)this.body);
/* 205 */       GCOLOR.UI().bg(isActive, isSelected, isHovered).render(r, (RECTANGLE)this.body, -1);
/*     */       
/* 207 */       this.bu.boost.icon.medium.renderC(r, this.body.x1() + 16, this.body.cY());
/*     */       
/* 209 */       this.tt.clear();
/* 210 */       GFORMAT.i(this.tt, (long)(this.bu.boost.get((BOOSTABLE_O)PlayOutput.this.g.get()) + this.bu.boostYearlyPart.get((BOOSTABLE_O)PlayOutput.this.g.get())));
/*     */       
/* 212 */       this.tt.renderC(r, this.body.x1() + 32, this.body.cY());
/*     */     }
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
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 225 */       if (this.bu.boostYearlyPart.get((BOOSTABLE_O)PlayOutput.this.g.get()) > 0.0D) {
/* 226 */         this.bu.boostYearlyPart.hover(text, (BOOSTABLE_O)PlayOutput.this.g.get(), true);
/* 227 */         GBox b = (GBox)text;
/* 228 */         b.sep();
/* 229 */         GText t = b.text();
/* 230 */         t.add(PlayOutput.¤¤ship);
/* 231 */         t.insert(0, this.bu.daysUntilDailydelivery());
/* 232 */         t.insert(1, this.bu.yearlyAccumilation.get(PlayOutput.this.g.get()));
/* 233 */         b.add((SPRITE)t);
/* 234 */         b.sep();
/*     */         
/* 236 */         if (this.bu.boost.get((BOOSTABLE_O)PlayOutput.this.g.get()) > 0.0D) {
/* 237 */           this.bu.boost.hover(text, (BOOSTABLE_O)PlayOutput.this.g.get(), true);
/*     */         }
/*     */       } else {
/*     */         
/* 241 */         this.bu.boost.hover(text, (BOOSTABLE_O)PlayOutput.this.g.get(), true);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayOutput.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */