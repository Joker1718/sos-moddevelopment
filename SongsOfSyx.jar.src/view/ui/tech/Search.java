/*    */ package view.ui.tech;
/*    */ 
/*    */ import game.boosting.BoostSpec;
/*    */ import init.sprite.UI.UI;
/*    */ import init.tech.TECH;
/*    */ import init.tech.TECHS;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.gui.misc.GText;
/*    */ import util.gui.misc.GTextR;
/*    */ import util.text.D;
/*    */ 
/*    */ final class Search
/*    */   extends GuiSection {
/* 16 */   private static CharSequence ¤¤no = "No results";
/*    */   
/*    */   static {
/* 19 */     D.ts(Search.class);
/*    */   }
/*    */   
/* 22 */   private final Node[] nodes = new Node[TECHS.ALL().size()];
/* 23 */   private final RENDEROBJ no = (RENDEROBJ)new GTextR((new GText((UI.FONT()).M, ¤¤no)).warnify());
/*    */   private final int width;
/*    */   private final int height;
/*    */   
/*    */   Search(int height, int width) {
/* 28 */     this.width = width;
/* 29 */     this.height = height;
/* 30 */     NodeBoosts bos = new NodeBoosts();
/* 31 */     for (int i = 0; i < this.nodes.length; i++) {
/* 32 */       this.nodes[i] = new Node((TECH)TECHS.ALL().get(i), bos);
/*    */     }
/* 34 */     body().setDim(width, height);
/*    */   }
/*    */ 
/*    */   
/*    */   GuiSection set(CharSequence s) {
/* 39 */     int x1 = body().x1();
/* 40 */     int y1 = body().y1();
/* 41 */     clear();
/*    */     
/* 43 */     int x = 0;
/* 44 */     int y = 0;
/*    */     
/* 46 */     for (TECH t : TECHS.ALL()) {
/* 47 */       if (!contains(t, s)) {
/*    */         continue;
/*    */       }
/* 50 */       Node n = this.nodes[t.index()];
/*    */       
/* 52 */       if (x + 8 + 80 > this.width) {
/*    */         
/* 54 */         y += 8 + Node.HEIGHT();
/* 55 */         if (y + 8 + Node.HEIGHT() > this.height) {
/*    */           break;
/*    */         }
/*    */       } 
/*    */ 
/*    */       
/* 61 */       n.body().moveX1Y1(x, y);
/* 62 */       add((RENDEROBJ)n);
/* 63 */       x += 96;
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 68 */     body().moveX1Y1(x1, y1);
/* 69 */     body().setDim(this.width, this.height);
/*    */     
/* 71 */     if (x == 0 && y == 0) {
/* 72 */       add(this.no, body().cX(), body().cY());
/*    */     }
/*    */     
/* 75 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   private boolean contains(TECH t, CharSequence s) {
/* 80 */     if (Str.containsText(t.name(), s))
/* 81 */       return true; 
/* 82 */     if (Str.containsText(t.desc(), s)) {
/* 83 */       return true;
/*    */     }
/* 85 */     for (BoostSpec b : t.boosters.all()) {
/* 86 */       if (Str.containsText(s, b.boostable.name)) {
/* 87 */         return true;
/*    */       }
/*    */     } 
/*    */     
/* 91 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\Search.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */