/*     */ package settlement.stats.service;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.util.StatHoverer;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends STATFake
/*     */ {
/*     */   null(String $anonymous0, StatsInit $anonymous1, StatInfo $anonymous2) {
/*  65 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getDD(HCLASS s, Race r, int daysBack) {
/*  70 */     double a = StatServiceRoom.this.access.data(s).getD(r, daysBack);
/*  71 */     if (a == 0.0D)
/*  72 */       return 0.0D; 
/*  73 */     double q = StatServiceRoom.this.quality.data(s).getD(r, daysBack) / a;
/*  74 */     double p = StatServiceRoom.this.proximity.data(s).getD(r, daysBack) / a;
/*  75 */     double u = StatServiceRoom.this.upgrade.data(s).getD(r, daysBack) / a;
/*  76 */     return a * (0.2D + 0.8D * u) * (0.2D + 0.8D * q) * (
/*  77 */       0.5D + 0.5D * p);
/*     */   }
/*     */ 
/*     */   
/*     */   public double induGet(Induvidual t) {
/*  82 */     double a = StatServiceRoom.this.access.indu().getD(t);
/*  83 */     if (a == 0.0D)
/*  84 */       return 0.0D; 
/*  85 */     double q = StatServiceRoom.this.quality.indu().getD(t);
/*  86 */     double p = StatServiceRoom.this.proximity.indu().getD(t);
/*  87 */     double u = StatServiceRoom.this.upgrade.indu().getD(t);
/*     */     
/*  89 */     return a * (0.2D + 0.8D * u) * (0.2D + 0.8D * q) * (
/*  90 */       0.5D + 0.5D * p);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, HCLASS cl, Race race) {
/*  95 */     GBox b = (GBox)text;
/*  96 */     StatHoverer.hover((GUI_BOX)b, (STAT)this);
/*  97 */     b.sep();
/*  98 */     b.textLL((StatServiceRoom.this.access().info()).name);
/*  99 */     b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceRoom.this.access().data(cl).getD(race)));
/* 100 */     b.NL().text((StatServiceRoom.this.access().info()).desc);
/* 101 */     b.NL(4);
/* 102 */     b.textLL((StatServiceRoom.this.proximity().info()).name);
/* 103 */     double p = StatServiceRoom.this.proximity().data(cl).getD(race) / StatServiceRoom.this.access().data(cl).getD(race);
/*     */     
/* 105 */     b.add((SPRITE)GFORMAT.perc(b.text(), p));
/* 106 */     b.NL().text((StatServiceRoom.this.proximity().info()).desc);
/* 107 */     b.NL(4);
/* 108 */     b.textLL((StatServiceRoom.this.quality().info()).name);
/* 109 */     b.add((SPRITE)GFORMAT.perc(b.text(), CLAMP.d(StatServiceRoom.this.quality().data(cl).getD(race) / StatServiceRoom.this.access().data(cl).getD(race), 0.0D, 1.0D)));
/* 110 */     b.NL().text((StatServiceRoom.this.quality().info()).desc);
/* 111 */     b.NL(4);
/* 112 */     b.textLL((StatServiceRoom.this.upgrade().info()).name);
/* 113 */     b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceRoom.this.upgrade().data(cl).getD(race) / StatServiceRoom.this.access().data(cl).getD(race)));
/* 114 */     b.NL().text((StatServiceRoom.this.upgrade().info()).desc);
/* 115 */     b.NL(4);
/* 116 */     b.textLL(Dic.¤¤Total);
/* 117 */     b.add((SPRITE)GFORMAT.perc(b.text(), data(cl).getD(race)));
/*     */     
/* 119 */     b.sep();
/* 120 */     StatHoverer.hover(text, (STAT)this, cl, race);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, Induvidual indu) {
/* 125 */     GBox b = (GBox)text;
/* 126 */     StatHoverer.hover((GUI_BOX)b, (STAT)this);
/* 127 */     b.sep();
/* 128 */     b.textLL((StatServiceRoom.this.access().info()).name);
/* 129 */     b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceRoom.this.access().indu().getD(indu)));
/* 130 */     b.NL().text((StatServiceRoom.this.access().info()).desc);
/* 131 */     b.NL(4);
/* 132 */     b.textLL((StatServiceRoom.this.proximity().info()).name);
/*     */ 
/*     */     
/* 135 */     b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceRoom.this.proximity().indu().getD(indu) / StatServiceRoom.this.access().indu().getD(indu)));
/* 136 */     b.NL().text((StatServiceRoom.this.proximity().info()).desc);
/* 137 */     b.NL(4);
/* 138 */     b.textLL((StatServiceRoom.this.quality().info()).name);
/* 139 */     b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceRoom.this.quality().indu().getD(indu) / StatServiceRoom.this.access().indu().getD(indu)));
/* 140 */     b.NL().text((StatServiceRoom.this.quality().info()).desc);
/* 141 */     b.NL(4);
/* 142 */     b.textLL((StatServiceRoom.this.upgrade().info()).name);
/* 143 */     b.add((SPRITE)GFORMAT.perc(b.text(), StatServiceRoom.this.upgrade().indu().getD(indu) / StatServiceRoom.this.access().indu().getD(indu)));
/* 144 */     b.NL().text((StatServiceRoom.this.upgrade().info()).desc);
/* 145 */     b.NL(4);
/* 146 */     b.textLL(Dic.¤¤Total);
/* 147 */     b.add((SPRITE)GFORMAT.perc(b.text(), indu().getD(indu)));
/*     */     
/* 149 */     b.sep();
/* 150 */     StatHoverer.hover(text, (STAT)this, indu);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\service\StatServiceRoom$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */