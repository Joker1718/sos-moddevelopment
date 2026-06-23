/*     */ package view.ui.tech;
/*     */ 
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.UI.UI;
/*     */ import init.tech.TECH;
/*     */ import init.tech.TECHS;
/*     */ import java.util.Comparator;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.misc.GTextR;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ final class InfoBonuses
/*     */   extends GuiSection {
/*  32 */   private final int WIDTH = 300;
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
/*     */   private final UITechTree tree;
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
/*     */   private final GText t;
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
/*     */   public InfoBonuses(UITechTree tree, int height, int width) {
/* 116 */     this.t = new GText((UI.FONT()).S, 20); this.tree = tree; int cc = (int)Math.ceil(width / 348.0D); ArrayList<ArrayListGrower<Object>> cols = new ArrayList(cc); int max = 0; while (cols.hasRoom()) cols.add(new ArrayListGrower());  KeyMap<BoostableCat> map = new KeyMap(); for (Boostable b : BOOSTING.ALL()) { if (map.get(b.cat.prefix) == null)
/*     */         map.put(b.cat.prefix, b.cat);  }  ArrayList<BoostableCat> cats = new ArrayList((Iterable)map.all()); cats.sort(new Comparator<BoostableCat>() { public int compare(BoostableCat o1, BoostableCat o2) { return o2.all().size() - o1.all().size(); } }); for (BoostableCat c : cats) { ArrayListGrower<Object> current = null; for (ArrayListGrower<Object> l : cols) { if (current == null || l.size() < current.size())
/*     */           current = l;  }  if (current.size() > 0)
/*     */         current.add(null);  current.add(c); for (Boostable b : c.all())
/*     */         current.add(b);  max = Math.max(current.size(), max); }  LinkedList<RENDEROBJ> rens = new LinkedList(); for (int i = 0; i < max; i++) { GuiSection row = new GuiSection(); int ri = 0; for (ArrayListGrower<Object> l : cols) { Boo boo; RENDEROBJ r = null; if (l.size() <= i) { RENDEROBJ.RenderDummy renderDummy = new RENDEROBJ.RenderDummy(300, 18); } else { Object o = l.get(i); if (o == null) { RENDEROBJ.RenderDummy renderDummy = new RENDEROBJ.RenderDummy(300, 18); } else if (o instanceof BoostableCat) { GTextR R = new GTextR((UI.FONT()).S, ((BoostableCat)o).name); R.setColor((GCOLOR.T()).H1); GTextR gTextR1 = R; } else { boo = new Boo((Boostable)o); }  }  row.add((RENDEROBJ)boo, 300 * ri, body().y1()); ri++; }  rens.add(row); }  add((RENDEROBJ)(new GScrollRows((Iterable)rens, height - 8)).view());
/* 121 */   } public void render(SPRITE_RENDERER r, float ds) { super.render(r, ds); }
/*     */ 
/*     */   
/*     */   private class Boo
/*     */     extends CLICKABLE.ClickableAbs {
/*     */     private final Boostable bo;
/* 127 */     private ArrayListGrower<TECH> techs = new ArrayListGrower();
/*     */     
/*     */     public Boo(Boostable bo) {
/* 130 */       super(300, 18);
/* 131 */       this.bo = bo;
/* 132 */       for (TECH t : TECHS.ALL()) {
/* 133 */         for (BoostSpec b : t.boosters.all()) {
/* 134 */           if (b.boostable == bo) {
/* 135 */             this.techs.add(t);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 143 */       if (this.techs.size() == 0) {
/* 144 */         OPACITY.O50.bind();
/* 145 */       } else if (!isHovered) {
/* 146 */         OPACITY.O85.bind();
/*     */       } 
/* 148 */       this.bo.icon.render(r, body().x1(), body().y1());
/*     */       
/* 150 */       if (this.techs.size() > 0)
/* 151 */         (GCOLOR.T()).H1.bind(); 
/* 152 */       (UI.FONT()).S.render(r, this.bo.name, body().x1() + 20, body().y1(), 0, (this.bo.name.length() > 15) ? 15 : this.bo.name.length(), 1.0D);
/* 153 */       COLOR.unbind();
/* 154 */       OPACITY.unbind();
/* 155 */       InfoBonuses.this.t.clear();
/* 156 */       double add = 0.0D;
/* 157 */       double mul = 1.0D;
/* 158 */       for (TECH t : this.techs) {
/* 159 */         for (BoostSpec b : t.boosters.all()) {
/* 160 */           if (b.boostable == this.bo) {
/* 161 */             if (b.booster.isMul) {
/* 162 */               mul *= (FACTIONS.player()).tech.level(t) * (b.booster.to() - 1.0D) + 1.0D; continue;
/*     */             } 
/* 164 */             add += (FACTIONS.player()).tech.level(t) * b.booster.to();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 170 */       GFORMAT.percInc(InfoBonuses.this.t, (add + 1.0D) * mul - 1.0D);
/* 171 */       InfoBonuses.this.t.render(r, this.body.x1() + 220, this.body.y1());
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 176 */       if (this.techs.size() == 0)
/*     */         return; 
/* 178 */       InfoBonuses.this.tree.filter.set(this.bo.name);
/* 179 */       super.clickA();
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 184 */       text.title(this.bo.name);
/* 185 */       text.text(this.bo.desc);
/* 186 */       text.NL(8);
/*     */       
/* 188 */       GBox box = (GBox)text;
/* 189 */       for (TECH t : this.techs) {
/* 190 */         for (BoostSpec b : t.boosters.all()) {
/* 191 */           if (b.boostable == this.bo) {
/* 192 */             if (b.booster.isMul) {
/* 193 */               b.booster.hover((GUI_BOX)box, (FACTIONS.player()).tech.level(t) * (b.booster.to() - 1.0D) + 1.0D); continue;
/*     */             } 
/* 195 */             b.booster.hover((GUI_BOX)box, (FACTIONS.player()).tech.level(t) * b.booster.to());
/*     */           } 
/*     */         } 
/*     */         
/* 199 */         box.NL();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\InfoBonuses.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */