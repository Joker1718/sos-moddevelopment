/*     */ package view.world.ui.faction;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.common.UIPickerRegion;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ final class Realm extends GuiSection {
/*     */   Realm(final GETTER.GETTER_IMP<FactionNPC> f, int height) {
/*  30 */     GuiSection s = new GuiSection();
/*  31 */     s.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  35 */             GFORMAT.i(text, AD.men(null).faction((Faction)f.get()));
/*     */           }
/*  40 */         }).hh(Dic.¤¤Soldiers));
/*     */     
/*  42 */     s.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  46 */             GFORMAT.i(text, AD.conscripts().total(null).get(f.get()));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  52 */             for (Race r : RACES.all()) {
/*  53 */               b.add((SPRITE)(r.appearance()).icon);
/*  54 */               b.textLL(r.info.names);
/*  55 */               b.tab(6);
/*  56 */               b.add((SPRITE)GFORMAT.i(b.text(), AD.conscripts().total(r).get(f.get())));
/*  57 */               b.text((CharSequence)b.text().add('(').add(RD.MILITARY().conscripts(r, (Faction)f.get())).add(')'));
/*  58 */               b.NL();
/*     */             
/*     */             }
/*     */           
/*     */           }
/*  63 */         }).hh(Dic.¤¤Conscripts));
/*  64 */     s.addRelBody(8, DIR.S, (RENDEROBJ)new UIPickerArmy((GETTER)f, height - body().height() - 16)
/*     */         {
/*     */           protected boolean canBePicked(WArmy a)
/*     */           {
/*  68 */             return !WORLD.FOW().is(a.ctx(), a.cty());
/*     */           }
/*     */ 
/*     */           
/*     */           protected void pick(WArmy a) {
/*  73 */             if (!WORLD.FOW().is(a.ctx(), a.cty())) {
/*  74 */               VIEW.world().activate();
/*  75 */               (VIEW.UI()).manager.close();
/*  76 */               (VIEW.world()).window.centererTile.set(a.ctx(), a.cty());
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void hover(GUI_BOX text, WArmy a) {
/*  82 */             if (!WORLD.FOW().is(a.ctx(), a.cty())) {
/*  83 */               super.hover(text, a);
/*     */             }
/*     */           }
/*     */         });
/*     */     
/*  88 */     add((RENDEROBJ)s);
/*     */     
/*  90 */     s = new GuiSection();
/*  91 */     addRelBody(16, DIR.E, (RENDEROBJ)new RENDEROBJ.RenderImp(1, height)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/*  95 */             GCOLOR.UI().border().render(r, (RECTANGLE)this.body);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 100 */     s.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 104 */             int am = 0;
/* 105 */             for (Region r : ((FactionNPC)f.get()).realm().all())
/* 106 */               am += r.info.area(); 
/* 107 */             GFORMAT.i(text, am);
/*     */           }
/* 110 */         }).hh(Dic.¤¤Area));
/* 111 */     s.addRelBody(8, DIR.S, (RENDEROBJ)new UIPickerRegion((GETTER)f, height - 16)
/*     */         {
/*     */           protected void toggle(Region reg)
/*     */           {
/* 115 */             VIEW.world().activate();
/* 116 */             (VIEW.UI()).manager.close();
/* 117 */             (VIEW.world()).window.centererTile.set(reg.cx(), reg.cy());
/* 118 */             (VIEW.world()).UI.regions.open(reg);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     addRelBody(16, DIR.E, (RENDEROBJ)s);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Realm.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */