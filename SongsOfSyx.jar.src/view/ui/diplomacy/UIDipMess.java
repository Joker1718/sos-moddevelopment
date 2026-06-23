/*     */ package view.ui.diplomacy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.Serializable;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GText;
/*     */ import view.ui.message.MessageSection;
/*     */ 
/*     */ 
/*     */ public class UIDipMess
/*     */   extends MessageSection
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String mess;
/*     */   private final String desc;
/*     */   private final MessIntro intro;
/*     */   
/*     */   public UIDipMess(CharSequence title, CharSequence message, CharSequence desc, FactionNPC f) {
/*  28 */     super(title);
/*  29 */     this.desc = String.valueOf(desc);
/*  30 */     this.mess = String.valueOf(message);
/*  31 */     this.intro = new MessIntro(f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/*  39 */     paragraph(this.mess);
/*  40 */     section.addRelBody(8, DIR.N, (RENDEROBJ)this.intro.make());
/*     */     
/*  42 */     section.addRelBody(8, DIR.S, (SPRITE)(new GText((UI.FONT()).M, this.desc)).lablifySub().setMaxWidth(900));
/*     */   }
/*     */ 
/*     */   
/*     */   static class MessFaction
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final int fi;
/*     */     
/*     */     private final int fii;
/*     */     
/*     */     MessFaction(FactionNPC f) {
/*  56 */       this.fi = f.index();
/*  57 */       this.fii = f.iteration();
/*     */     }
/*     */     
/*     */     public FactionNPC faction() {
/*  61 */       Faction f = FACTIONS.getByIndex(this.fi);
/*  62 */       if (f == null || !f.isActive() || !(f instanceof FactionNPC))
/*  63 */         return null; 
/*  64 */       FactionNPC npc = (FactionNPC)f;
/*  65 */       if (npc.iteration() != this.fii)
/*  66 */         return null; 
/*  67 */       return npc;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class MessIntro
/*     */     extends MessFaction
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final Induvidual iking;
/*     */     
/*     */     private final String sKingName;
/*     */     
/*     */     private final String sRealmIntro;
/*     */     
/*     */     MessIntro(FactionNPC f) {
/*  84 */       super(f);
/*  85 */       Induvidual k = (f.court().king().roy()).induvidual;
/*  86 */       this.iking = new Induvidual(k.hType(), k.race());
/*  87 */       this.iking.copyFrom(k);
/*  88 */       STATS.NEEDS().clear(this.iking);
/*     */       
/*  90 */       this.sKingName = (f.court().king()).name.toString();
/*  91 */       this.sRealmIntro = f.nameIntro.toString() + " " + f.nameIntro.toString();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public GuiSection make() {
/*  97 */       GuiSection r = new GuiSection();
/*  98 */       if (faction() != null) {
/*  99 */         r.add((faction().banner()).HUGE, 0, 0);
/*     */       }
/* 101 */       SPRITE.Imp imp = new SPRITE.Imp(80, 128)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 105 */             STATS.APPEARANCE().portraitRender(r, UIDipMess.MessIntro.this.iking, X1, Y1, 2);
/* 106 */             if ((UIDipMess.MessIntro.this.iking.race().appearance()).crown.crowns().size() > 0) {
/* 107 */               ((SPRITE)(UIDipMess.MessIntro.this.iking.race().appearance()).crown.crowns().get(0)).renderScaled(r, X1, Y1 + 16, 2);
/*     */             }
/*     */           }
/*     */         };
/* 111 */       r.addRelBody(32, DIR.E, (SPRITE)imp);
/* 112 */       if (faction() != null) {
/* 113 */         r.addRelBody(32, DIR.E, (faction().banner()).HUGE);
/*     */       }
/*     */ 
/*     */       
/* 117 */       r.addRelBody(4, DIR.S, (SPRITE)(new GText((UI.FONT()).H2, this.sKingName)).lablify());
/*     */       
/* 119 */       r.addRelBody(4, DIR.S, (SPRITE)(new GText((UI.FONT()).M, this.sRealmIntro)).normalify());
/*     */       
/* 121 */       return r;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDipMess.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */