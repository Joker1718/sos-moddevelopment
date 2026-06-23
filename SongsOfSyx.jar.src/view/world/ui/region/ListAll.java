/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FBanner;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ListAll
/*     */   extends ISidePanel
/*     */ {
/*  37 */   private final int width = 400;
/*  38 */   private final int height = 30;
/*  39 */   private final GTableSorter<Region> sorter; private final StringInputSprite s; private GTableSorter.GTFilter<Region> filterName; private final GTableSorter.GTSort<Region> sort; private final GTableBuilder builder; private final GText textH; private final GText textS; protected void update(float ds) { this.sorter.sort(); } ListAll() { D.gInit(this);
/*     */     
/*  41 */     this.sorter = new GTableSorter<Region>(1023)
/*     */       {
/*     */         protected Region getUnsorted(int index) {
/*  44 */           Region f = WORLD.REGIONS().getByIndex(index);
/*  45 */           if (f.info.area() > 0 && (f.faction() != FACTIONS.player() || !f.capitol()))
/*  46 */             return f; 
/*  47 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  53 */     this.filterName = new GTableSorter.GTFilter<Region>(D.g("search"))
/*     */       {
/*     */         public boolean passes(Region h) {
/*  56 */           return h.info.name().startsWithIgnoreCase((CharSequence)ListAll.this.s.text());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  61 */     this.sort = new GTableSorter.GTSort<Region>("blabla")
/*     */       {
/*     */         public int cmp(Region current, Region cmp)
/*     */         {
/*  65 */           return get(current) - get(cmp);
/*     */         }
/*     */         
/*     */         private int get(Region current) {
/*  69 */           int m = 1023 * FACTIONS.MAX();
/*  70 */           int res = current.index();
/*     */ 
/*     */ 
/*     */           
/*  74 */           Faction f = current.faction();
/*  75 */           if (f == null) {
/*  76 */             res += 3 * m;
/*  77 */           } else if (f != FACTIONS.player()) {
/*  78 */             res += m;
/*  79 */             res += 1023 * f.index();
/*     */           } 
/*  81 */           return res;
/*     */         }
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
/*     */         public void format(Region h, GText text) {}
/*     */       };
/* 141 */     this.textH = new GText((UI.FONT()).H2, 30);
/* 142 */     this.textS = new GText((UI.FONT()).S, 30); this.sorter.setSort(this.sort); this.s = (new StringInputSprite(8, (UI.FONT()).H2) { protected void change() { ListAll.this.sorter.setFilter(ListAll.this.filterName); } }
/*     */       ).placeHolder(this.filterName.name); GInput in = new GInput(this.s); this.section.add((RENDEROBJ)in); this.builder = new GTableBuilder() { public int nrOFEntries() { return ListAll.this.sorter.size(); } }
/*     */       ;
/*     */     this.builder.column(null, 400, new GTableBuilder.GRowBuilder() { public RENDEROBJ build(GETTER<Integer> ier) { return (RENDEROBJ)new ListAll.Button(ier); } }
/*     */       );
/*     */     GuiSection s = this.builder.createHeight(HEIGHT - in.body.height() - 4, true);
/*     */     this.section.addDown(2, (RENDEROBJ)s);
/* 149 */     titleSet(D.g("Regions")); } private final class Button extends CLICKABLE.ClickableAbs { Button(GETTER<Integer> ier) { this.ier = ier;
/* 150 */       this.body.setWidth(400.0D);
/* 151 */       this.body.setHeight(30.0D); }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final GETTER<Integer> ier;
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 161 */       Region reg = (Region)ListAll.this.sorter.get(this.ier);
/* 162 */       (VIEW.world()).window.centererTile.set(reg.cx(), reg.cy());
/* 163 */       ISidePanel p = (VIEW.world()).UI.regions.get(reg);
/* 164 */       (VIEW.world()).panels.add(ListAll.this, true);
/* 165 */       (VIEW.world()).panels.add(p, false);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 171 */       Region f = (Region)ListAll.this.sorter.get(this.ier);
/* 172 */       selectedSet((VIEW.world()).UI.regions.active(f));
/* 173 */       GCOLOR.UI().border().render(r, (RECTANGLE)body());
/*     */       
/* 175 */       GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*     */       
/* 177 */       COLOR col = COLOR.WHITE85;
/* 178 */       if (f.faction() == null) {
/* 179 */         FBanner.rebel.MEDIUM.renderCY(r, 8, body().cY());
/*     */       } else {
/* 181 */         (f.faction().banner()).MEDIUM.renderCY(r, 8, body().cY());
/* 182 */         if (f.capitol()) {
/* 183 */           (UI.icons()).s.crown.renderCY(r, 6, this.body.cY() - 8);
/*     */         }
/* 185 */         if (f.faction() == null) {
/* 186 */           col = (GCOLOR.T()).INORMAL;
/*     */         }
/* 188 */         else if (DIP.WAR().is((Faction)FACTIONS.player(), f.faction())) {
/* 189 */           col = (GCOLOR.T()).IBAD;
/*     */         } else {
/* 191 */           col = (GCOLOR.T()).IGOOD;
/*     */         } 
/*     */       } 
/*     */       
/* 195 */       ListAll.this.textH.clear();
/* 196 */       ListAll.this.textH.color(col);
/* 197 */       ListAll.this.textH.add((CharSequence)f.info.name());
/* 198 */       ListAll.this.textH.setMaxWidth(340);
/* 199 */       ListAll.this.textH.setMultipleLines(false);
/*     */       
/* 201 */       ListAll.this.textH.renderCY(r, 40, body().cY());
/*     */       
/* 203 */       ListAll.this.textS.clear();
/* 204 */       GFORMAT.i(ListAll.this.textS, (RD.RACES()).population.get(f));
/* 205 */       ListAll.this.textS.adjustWidth();
/* 206 */       ListAll.this.textS.renderCY(r, this.body.x2() - 8 - ListAll.this.textS.width(), this.body.cY());
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 211 */       Region f = (Region)ListAll.this.sorter.get(this.ier);
/* 212 */       (VIEW.world()).UI.regions.hover(f, text);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISidePanel get(Region f) {
/* 219 */     this.sorter.sortForced();
/* 220 */     if (f != null) {
/* 221 */       this.builder.set(this.sorter.getIndex(f));
/*     */     }
/*     */     
/* 224 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\ListAll.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */