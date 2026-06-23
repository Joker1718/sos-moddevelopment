/*     */ package view.ui.profile;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Comparator;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public abstract class UIBonus
/*     */   extends GuiSection
/*     */ {
/*  37 */   private final StringInputSprite in = (new StringInputSprite(16, (UI.FONT()).M)).placeHolder(Dic.¤¤Search);
/*     */   
/*     */   private final GETTER<BOOSTABLE_O> bbb;
/*     */   public Faction f;
/*     */   
/*     */   public UIBonus(GETTER<BOOSTABLE_O> bbb, GETTER<Faction> f, int height) {
/*  43 */     this.bbb = bbb;
/*     */     
/*  45 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/*  47 */     ArrayList<Boostable> all = new ArrayList(BOOSTING.ALL().size());
/*  48 */     for (Boostable b : BOOSTING.ALL()) {
/*  49 */       if (is(b)) {
/*  50 */         all.add(b);
/*     */       }
/*     */     } 
/*  53 */     addRelBody(0, DIR.S, (RENDEROBJ)new GInput(this.in));
/*     */     
/*  55 */     BoostableCat cat = null;
/*     */     
/*  57 */     Row rr = new Row((Boostable)BOOSTING.ALL().get(0));
/*     */     
/*  59 */     all.sort(new Comparator<Boostable>()
/*     */         {
/*     */           public int compare(Boostable arg0, Boostable arg1)
/*     */           {
/*  63 */             return String.valueOf(arg0.cat.name).compareTo(String.valueOf(arg1.cat.name));
/*     */           }
/*     */         });
/*     */     
/*  67 */     for (Boostable b : all) {
/*  68 */       if (b.name == null || b.name.length() == 0)
/*     */         continue; 
/*  70 */       if (b.cat != cat) {
/*  71 */         cat = b.cat;
/*  72 */         rows.add(new RENDEROBJ.RenderImp(rr.body().width(), rr.body().height(), b) {
/*     */               GText h;
/*     */               
/*     */               public void render(SPRITE_RENDERER r, float ds) {
/*  76 */                 this.h.renderCY(r, body().x1() + 20, body().cY());
/*  77 */                 GCOLOR.UI().border().render(r, body().x1(), body().x2(), body().y2() - 1, body().y2());
/*     */               }
/*     */             });
/*     */       } 
/*  81 */       double min = b.min(null);
/*  82 */       double max = b.max(null);
/*  83 */       if (min == b.baseValue && max == b.baseValue)
/*     */         continue; 
/*  85 */       rows.add(new Row(b));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     addRelBody(8, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows, height - body().height() - 16, 0)
/*     */         {
/*     */           protected boolean passesFilter(int i, RENDEROBJ o)
/*     */           {
/*  95 */             if (UIBonus.this.in.text().length() == 0)
/*  96 */               return true; 
/*  97 */             if (o instanceof UIBonus.Row) {
/*  98 */               UIBonus.Row r = (UIBonus.Row)o;
/*  99 */               if (Str.containsText(r.bo.name, (CharSequence)UIBonus.this.in.text()) || Str.containsText(r.bo.desc, (CharSequence)UIBonus.this.in.text()))
/* 100 */                 return true; 
/* 101 */               return false;
/*     */             } 
/* 103 */             return false;
/*     */           }
/* 108 */         }).view());
/*     */     
/* 110 */     addRelBody(8, DIR.E, (RENDEROBJ)new Effects(f, height));
/*     */   }
/*     */   
/*     */   protected abstract boolean is(Boostable paramBoostable);
/*     */   
/*     */   private class Row
/*     */     extends HOVERABLE.HoverableAbs
/*     */   {
/*     */     private final Boostable bo;
/*     */     private final SPRITE ico;
/*     */     private final GText t;
/*     */     
/*     */     Row(Boostable bo) {
/* 123 */       super(450, 48);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 128 */       this.t = new GText((UI.FONT()).S, 16);
/*     */       this.bo = bo;
/*     */       this.ico = bo.icon.resized(32);
/*     */     } protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 132 */       double min = this.bo.min(((BOOSTABLE_O)UIBonus.this.bbb.get()).getClass());
/* 133 */       double max = this.bo.max(((BOOSTABLE_O)UIBonus.this.bbb.get()).getClass());
/* 134 */       if (min == this.bo.baseValue && max == this.bo.baseValue) {
/*     */         return;
/*     */       }
/* 137 */       double d = this.bo.get((BOOSTABLE_O)UIBonus.this.bbb.get());
/*     */       
/* 139 */       GMeter.renderDelta(r, this.bo.baseValue / max, d / max, this.body.x1(), this.body.x2() - 90, this.body.y1(), this.body.y2(), GMeter.C_GRAY);
/*     */       
/* 141 */       this.ico.renderCY(r, this.body.x1() + 16, this.body.cY());
/*     */       
/* 143 */       int w = (UI.FONT()).M.width(this.bo.name);
/* 144 */       OPACITY.O50.bind();
/* 145 */       COLOR.BLACK.render(r, this.body.x1() + 46, this.body.x1() + 50 + w + 8, this.body.y1() + 10, this.body.y2() - 10);
/* 146 */       OPACITY.unbind();
/*     */       
/* 148 */       (UI.FONT()).M.renderCY(r, this.body.x1() + 50, this.body.cY(), this.bo.name);
/*     */       
/* 150 */       this.t.clear();
/* 151 */       if (min == this.bo.baseValue && max == this.bo.baseValue)
/*     */         return; 
/* 153 */       if (this.bo.baseValue == 0.0D) {
/* 154 */         GFORMAT.percInc(this.t, this.bo.get((BOOSTABLE_O)UIBonus.this.bbb.get()));
/*     */       } else {
/* 156 */         GFORMAT.percInc(this.t, this.bo.get((BOOSTABLE_O)UIBonus.this.bbb.get()) / this.bo.baseValue - 1.0D);
/* 157 */       }  this.t.renderCY(r, this.body.x2() - 80, this.body.cY());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 164 */       text.title(this.bo.name);
/* 165 */       text.text(this.bo.desc);
/* 166 */       text.NL(8);
/* 167 */       this.bo.hoverDetailed(text, (BOOSTABLE_O)UIBonus.this.bbb.get(), null, true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Effects
/*     */     extends RENDEROBJ.RenderImp
/*     */   {
/*     */     private final GETTER<Faction> fa;
/*     */     
/*     */     Effects(GETTER<Faction> fa, int height) {
/* 178 */       super(400, height);
/*     */       
/* 180 */       this.fa = fa;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 185 */       GBox.tmp.clear();
/* 186 */       GBox.tmp.maxWidth = this.body.width();
/* 187 */       GBox.tmp.maxHeight = this.body.height();
/* 188 */       GAME.BOOST().hover(GBox.tmp, (Faction)this.fa.get());
/* 189 */       GBox.tmp.renderWithout(r, this.body.x1(), this.body.y1());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\UIBonus.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */