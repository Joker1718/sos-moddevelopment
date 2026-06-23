/*    */ package view.world.ui.faction;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.text.Dic;
/*    */ import world.region.RD;
/*    */ 
/*    */ final class Banner
/*    */   extends GuiSection {
/*    */   Banner(final GETTER<FactionNPC> f, int width) {
/* 23 */     body().setWidth(700.0D);
/*    */     
/* 25 */     addRelBody(2, DIR.S, (RENDEROBJ)(new GStat(new GText((UI.FONT()).M, 32))
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 29 */             text.add((CharSequence)((FactionNPC)f.get()).nameIntro);
/*    */           }
/* 31 */         }).r(DIR.N));
/*    */     
/* 33 */     addRelBody(6, DIR.S, (RENDEROBJ)(new GStat(new GText((UI.FONT()).H1, 32))
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 37 */             text.add((CharSequence)((FactionNPC)f.get()).name);
/* 38 */             text.lablify();
/*    */           }
/* 40 */         }).r(DIR.N));
/*    */     
/* 42 */     addRelBody(4, DIR.S, (RENDEROBJ)(new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 46 */             if (!RD.DIST().reachable((Faction)f.get())) {
/* 47 */               if (RD.DIST().factionCanAttackPlayerAllies((Faction)f.get())) {
/* 48 */                 text.add(Dic.¤¤FactionBorder);
/*    */               } else {
/* 50 */                 text.add(Dic.¤¤Distant);
/*    */               } 
/*    */             } else {
/* 53 */               text.add((DIP.get((FactionNPC)f.get())).name);
/*    */             } 
/*    */           }
/*    */ 
/*    */           
/*    */           public void hoverInfoGet(GBox b) {
/* 59 */             DIP.get((FactionNPC)f.get()).hover((GUI_BOX)b);
/*    */           }
/* 62 */         }).r(DIR.N));
/*    */     
/* 64 */     RENDEROBJ rr = ban(f);
/* 65 */     rr.body().moveX1(0.0D).moveCY(body().cY());
/* 66 */     add(rr);
/*    */     
/* 68 */     rr = ban(f);
/* 69 */     rr.body().moveX2(700.0D).moveCY(body().cY());
/* 70 */     add(rr);
/*    */     
/* 72 */     GuiSection guiSection = Hoverer.facts(f, 1000, 90);
/* 73 */     addRelBody(4, DIR.S, (RENDEROBJ)guiSection);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private RENDEROBJ ban(final GETTER<FactionNPC> f) {
/* 79 */     return (RENDEROBJ)new RENDEROBJ.RenderImp(64)
/*    */       {
/*    */         public void render(SPRITE_RENDERER r, float ds)
/*    */         {
/* 83 */           (((FactionNPC)f.get()).banner()).HUGE.render(r, (RECTANGLE)body());
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Banner.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */