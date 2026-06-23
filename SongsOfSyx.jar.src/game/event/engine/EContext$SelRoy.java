/*     */ package game.event.engine;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.Royalty;
/*     */ import init.type.HTYPES;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ public class SelRoy
/*     */   extends EContext.SelContext<Royalty>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/* 688 */   private int i1 = -1;
/* 689 */   private int i2 = -1;
/* 690 */   private int ii1 = -1;
/* 691 */   private int ii2 = -1;
/*     */   private Induvidual roy;
/*     */   private boolean isKing;
/*     */   
/*     */   private SelRoy() {
/* 696 */     super("roy");
/*     */   }
/*     */ 
/*     */   
/*     */   public Royalty first() {
/* 701 */     if (this.i1 < 0)
/* 702 */       return null; 
/* 703 */     FactionNPC f = (FactionNPC)FACTIONS.all().get(this.i1);
/* 704 */     if (this.ii1 < f.court().all().size())
/* 705 */       return (Royalty)f.court().all().get(this.ii1); 
/* 706 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Royalty second() {
/* 711 */     if (this.i2 < 0)
/* 712 */       return null; 
/* 713 */     FactionNPC f = (FactionNPC)FACTIONS.all().get(this.i2);
/* 714 */     if (this.ii2 < f.court().all().size())
/* 715 */       return (Royalty)f.court().all().get(this.ii2); 
/* 716 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   void copy(EContext.SelContext<Royalty> o) {
/* 721 */     super.copy(o);
/* 722 */     this.i1 = -1;
/* 723 */     this.i2 = -1;
/* 724 */     if (o.first() != null) {
/* 725 */       this.i1 = ((Royalty)o.first()).court.faction.index();
/* 726 */       this.ii1 = ((Royalty)o.first()).successionI();
/*     */     } 
/* 728 */     if (o.second() != null) {
/* 729 */       this.i2 = ((Royalty)o.second()).court.faction.index();
/* 730 */       this.ii2 = ((Royalty)o.second()).successionI();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   SPRITE sprite() {
/* 736 */     if (this.roy != null)
/* 737 */       return (SPRITE)new SPRITE.Imp(120, 192)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 740 */             STATS.APPEARANCE().portraitRender(r, EContext.SelRoy.this.roy, X1, Y1, 3);
/* 741 */             if (EContext.SelRoy.this.isKing) {
/* 742 */               ((SPRITE)(EContext.SelRoy.this.roy.race().appearance()).crown.crowns().get(0)).renderScaled(r, X1, Y1 + 24, 3);
/*     */             }
/*     */           }
/*     */         }; 
/* 746 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   void set(Royalty first, Royalty second) {
/* 751 */     this.i1 = -1;
/* 752 */     this.i2 = -1;
/* 753 */     if (first != null) {
/* 754 */       this.i1 = first.court.faction.index();
/* 755 */       this.ii1 = first.successionI();
/* 756 */       if (this.roy == null)
/* 757 */         this.roy = new Induvidual(HTYPES.NOBILITY(), FACTIONS.player().race()); 
/* 758 */       this.roy.copyFromHard(first.induvidual);
/*     */     } 
/* 760 */     if (second != null) {
/* 761 */       this.i2 = second.court.faction.index();
/* 762 */       this.ii2 = second.successionI();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int max() {
/* 769 */     return FACTIONS.NPCs().size() * 4;
/*     */   }
/*     */ 
/*     */   
/*     */   Royalty get(int index) {
/* 774 */     int fi = index / 4;
/* 775 */     if (fi < 0)
/* 776 */       return null; 
/* 777 */     Faction ff = (Faction)FACTIONS.all().get(fi);
/* 778 */     if (ff == null || !(ff instanceof FactionNPC))
/* 779 */       return null; 
/* 780 */     FactionNPC f = (FactionNPC)ff;
/* 781 */     if (!f.isActive())
/* 782 */       return null; 
/* 783 */     int ri = index % 4;
/* 784 */     if (ri < f.court().all().size())
/* 785 */       return (Royalty)f.court().all().get(ri); 
/* 786 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   void markSet(Royalty t, int id) {
/* 791 */     t.eventMark = (short)id;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int markGet(Royalty t) {
/* 797 */     return t.eventMark;
/*     */   }
/*     */ 
/*     */   
/*     */   void eventSet(Royalty t, int b) {
/* 802 */     t.eventSet((b == 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean eventGet(Royalty t) {
/* 808 */     return t.event();
/*     */   }
/*     */ 
/*     */   
/*     */   ESelection.ESelectionType<Royalty> sel(Event abs) {
/* 813 */     return abs.selection.royalty;
/*     */   }
/*     */ 
/*     */   
/*     */   Class<?> cl() {
/* 818 */     return Royalty.class;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EContext$SelRoy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */